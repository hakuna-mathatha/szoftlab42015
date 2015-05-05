package Phoebe.Controller;

import Phoebe.gamepackage.Displacement;
import Phoebe.gamepackage.Robot;

public class SlowDown2 extends IControlKeys {
	
	private static SlowDown2 slow = null;
	
	private SlowDown2() {
		this.bot = null;
	}
	
	public static SlowDown2 getInstance(){
		if(slow == null)
			slow = new SlowDown2();
		return slow;
	}

	@Override
	public void modifier() {
	
		if (bot.getVeloMod()) {
			Displacement d = bot.getDisplacement();
			d.setVelocity(d.getVelocity() - 5);
			bot.setDisplacement(d);
			bot.calcNextPosition();
		}

//		System.out.println("slow" + " " + bot.getDisplacement().getVelocity());
		
	}

	

}
