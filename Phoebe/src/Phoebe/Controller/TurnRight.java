package Phoebe.Controller;

import Phoebe.gamepackage.Displacement;
import Phoebe.gamepackage.Robot;

public class TurnRight extends IControlKeys {
	
	private static TurnRight turnright = null;
	
	private TurnRight() {
		this.bot = null;
	}
	
	public static TurnRight getInstance(){
		if(turnright == null)
			turnright =  new TurnRight();
		return turnright;
	}


	@Override
	public void modifier() {
		Displacement d = bot.getDisplacement();
		d.setAngle(d.getAngle() + 0.05);
		bot.setDisplacement(d);
		bot.calcNextPosition();

//		System.out.println("right" + " " + bot.getDisplacement().getAngle());
		
	}

	

}
