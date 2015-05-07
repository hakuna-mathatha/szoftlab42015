package Phoebe.Controller;
import Phoebe.gamepackage.Displacement;

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
		if (bot.getVeloMod()) {
			Displacement d = bot.getDisplacement();
			d.setVelocity(d.getVelocity() - 3);
			bot.setDisplacement(d);
			bot.calcNextPosition();
		}
	}
}
