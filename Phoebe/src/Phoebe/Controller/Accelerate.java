package Phoebe.Controller;

import Phoebe.Controller.ControlPlayTheGame.AccelerateListener;
import Phoebe.gamepackage.Displacement;
import Phoebe.gamepackage.Robot;
import Phoebe.gui.View;

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
			d.setVelocity(d.getVelocity() + 5);
			bot.setDisplacement(d);
			bot.calcNextPosition();
		}

		System.out.println("acc" + " " + bot.getDisplacement().getVelocity());
//		ControlPlayTheGame.AccelerateListener a = Control.getControlPlayTheGame().new AccelerateListener();
	
	}
	

}
