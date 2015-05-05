package Phoebe.Controller;

import Phoebe.gamepackage.Displacement;
import Phoebe.gamepackage.Robot;

public class TurnLeft extends IControlKeys {


	private static TurnLeft turnleft = null;
	
	private TurnLeft() {
		this.bot =null;
	}
	
	public static TurnLeft getInstance(){
		if(turnleft == null)
			turnleft = new TurnLeft();
		return turnleft;
	}



	

	@Override
	public void modifier() {
		Displacement d = bot.getDisplacement();
		d.setAngle(d.getAngle() - 0.05);
		bot.setDisplacement(d);
		bot.calcNextPosition();

		System.out.println("left" + " " + bot.getDisplacement().getAngle());

	}

}
