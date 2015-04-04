package Phoebe.trackpackage;

import Phoebe.basepackage.BaseType;
import Phoebe.gamepackage.Bot;
import Phoebe.gamepackage.Displacement;
import Phoebe.gamepackage.RobotState;

public class Edge extends Barrier {

	public Edge() {
		type = BaseType.edge;
	}
	
	@Override
	public void modifyDisplacement(Bot bot) {
		// TODO Auto-generated method stub
        System.out.println("\t\t"+getClass().getName()+":modifyDisplacement");
        Displacement disp = bot.getDisplacement();
        bot.modifyDisplacement(disp);
	}

	@Override
	public void setState(Bot bot) {
		// TODO Auto-generated method stub
        System.out.println("\t\t"+getClass().getName()+":setState");
        bot.setState(RobotState.died);
	}
	
	@Override
	public void stepOn(Bot aBot) {
		modifyDisplacement(aBot);
		setState(aBot);
		
	}
}