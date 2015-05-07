package Phoebe.Controller;
import Phoebe.gamepackage.Displacement;

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
		if (bot.getVeloMod()) {
			Displacement d = bot.getDisplacement();
			d.setVelocity(d.getVelocity() + 3);
			bot.setDisplacement(d);
			bot.calcNextPosition();
		}
	}
}
