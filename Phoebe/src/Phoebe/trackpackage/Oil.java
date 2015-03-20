package Phoebe.trackpackage;

import Phoebe.gamepackage.Bot;
import Phoebe.gamepackage.RobotState;
import Phoebe.gamepackage.Displacement;

public class Oil extends Barrier {

	@Override
	public void modifyDisplacement(Bot bot) {
		// TODO Auto-generated method stub
        System.out.println("\t\t"+getClass().getName()+":modifyDisplacement");
        Displacement disp = bot.getDisplacement();
        //modify disp
        bot.modifyDisplacement(disp);
	}

	@Override
	public void setState(Bot bot) {
		// TODO Auto-generated method stub
		System.out.println("\t\t"+getClass().getName()+":setState");
        bot.setState(RobotState.oil);
	}
}