package Phoebe.Controller;
import Phoebe.gamepackage.Displacement;
import Phoebe.trackpackage.Coordinate;

public class SlowDown extends IControlKeys {

	private static SlowDown slow = null;
	
	private SlowDown() {
		this.bot = null;
	}
	
	public static SlowDown getInstance(){
		if(slow == null)
			slow = new SlowDown();
		return slow;
	}

	@Override
	public void modifier() {
		Coordinate c = bot.getPosition().difCoord(bot.getNextPosition());
		double l = c.legth();
		if (bot.getVeloMod() && l>4) {
			Displacement d = bot.getDisplacement();
			d.setVelocity(d.getVelocity() - 3);
			bot.setDisplacement(d);
			bot.calcNextPosition();
		}
	}
}
