package Phoebe.trackpackage;

import Phoebe.basepackage.BaseType;
import Phoebe.gamepackage.Bot;
import Phoebe.gamepackage.Displacement;
import Phoebe.gamepackage.RobotState;

public class Putty extends Barrier {
	int countToRemove;
	
	public Putty() {
		type = BaseType.putty;
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
        bot.setState(RobotState.putty);
	}

	@Override
	public void stepOn(Bot aBot) {
		modifyDisplacement(aBot);
		setState(aBot);
		
	}
}