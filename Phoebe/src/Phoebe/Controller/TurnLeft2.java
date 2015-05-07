package Phoebe.Controller;
import Phoebe.gamepackage.Displacement;


public class TurnLeft2 extends IControlKeys {

	private static TurnLeft2 turnleft = null;
	
	private TurnLeft2() {
		this.bot =null;
	}
	
	public static TurnLeft2 getInstance(){
		if(turnleft == null)
			turnleft = new TurnLeft2();
		return turnleft;
	}

	@Override
	public void modifier() {
		Displacement d = bot.getDisplacement();
		d.setAngle(d.getAngle() - 0.05);
		bot.setDisplacement(d);
		bot.calcNextPosition();
	}
}
