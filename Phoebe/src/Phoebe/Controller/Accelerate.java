package Phoebe.Controller;
import Phoebe.gamepackage.Displacement;
import Phoebe.trackpackage.Coordinate;

public class Accelerate extends IControlKeys {

	private static Accelerate acc = null;
	
	public Accelerate() {
		this.bot = null;
	}
	
	public static Accelerate getInstance(){
		if(acc == null)
			acc = new Accelerate();
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
