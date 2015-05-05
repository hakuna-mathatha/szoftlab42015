package Phoebe.Controller;

import Phoebe.gamepackage.Displacement;
import Phoebe.gamepackage.Robot;

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
			d.setVelocity(d.getVelocity() - 5);
			bot.setDisplacement(d);
			bot.calcNextPosition();
		}

//		System.out.println("slow" + " " + bot.getDisplacement().getVelocity());
		
	}

	

}
