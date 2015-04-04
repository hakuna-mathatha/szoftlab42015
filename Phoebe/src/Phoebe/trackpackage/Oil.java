package Phoebe.trackpackage;

import java.util.Timer;

import Phoebe.basepackage.BaseType;
import Phoebe.gamepackage.Bot;
import Phoebe.gamepackage.RobotState;
import Phoebe.gamepackage.Displacement;

public class Oil extends Barrier {
	
	Timer timer;
	
	public Oil() {
		type = BaseType.oil;
	}
	
	@Override
	public void modifyDisplacement(Bot bot) {
        System.out.println("\t\t"+getClass().getName()+":modifyDisplacement");
        Displacement disp = bot.getDisplacement();
        bot.modifyDisplacement(disp);
	}

	@Override
	public void setState(Bot bot) {
		System.out.println("\t\t"+getClass().getName()+":setState");
        bot.setState(RobotState.oil);
	}

	@Override
	public void stepOn(Bot aBot) {
		System.out.println("\t\t\t" + getClass().getName() + ":stepOn");
		modifyDisplacement(aBot);
		setState(aBot);
		
	}
}