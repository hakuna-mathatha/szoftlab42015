package Phoebe.Controller;

import Phoebe.gamepackage.Displacement;
import Phoebe.gamepackage.Robot;

public class TurnRight2 extends IControlKeys {

	private static TurnRight2 turnright = null;
	
	private TurnRight2() {
		this.bot = null;
	}
	
	public static TurnRight2 getInstance(){
		if(turnright == null)
			turnright =  new TurnRight2();
		return turnright;
	}


	@Override
	public void modifier() {
		Displacement d = bot.getDisplacement();
		d.setAngle(d.getAngle() + 0.05);
		bot.setDisplacement(d);
		bot.calcNextPosition();

		System.out.println("right" + " " + bot.getDisplacement().getAngle());
		
	}

	

}
