package Phoebe.Controller;

import Phoebe.gamepackage.Displacement;
import Phoebe.gamepackage.Robot;

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
		if (bot.getVeloMod()) {
			Displacement d = bot.getDisplacement();
			d.setVelocity(d.getVelocity() + 5);
			bot.setDisplacement(d);
			bot.calcNextPosition();
		}

		System.out.println("acc" + " " + bot.getDisplacement().getVelocity());
		
	}
	

}
