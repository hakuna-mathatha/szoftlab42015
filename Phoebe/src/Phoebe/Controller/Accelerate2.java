package Phoebe.Controller;
import Phoebe.gamepackage.Displacement;
import Phoebe.trackpackage.Coordinate;

public class Accelerate2 extends IControlKeys {

	private static Accelerate2 acc = null;
	
	public Accelerate2() {
		bot = null;
	}
	
	public static Accelerate2 getInstance(){
		if(acc == null)
			acc = new Accelerate2();
		return acc;
	}

	@Override
	public void modifier() {
		Coordinate c = bot.getPosition().difCoord(bot.getNextPosition());
		double l = c.legth();
		if (bot.getVeloMod() && l<150) {
			Displacement d = bot.getDisplacement();
			d.setVelocity(d.getVelocity() + 3);
			bot.setDisplacement(d);
			bot.calcNextPosition();
		}
	}
}
