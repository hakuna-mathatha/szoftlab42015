package Phoebe.trackpackage;

import Phoebe.basepackage.BaseType;
import Phoebe.gamepackage.Bot;
import Phoebe.gamepackage.Displacement;
import Phoebe.gamepackage.RobotState;

public class Pure extends Barrier {

	public Pure() {}

	public Pure(Coordinate position, BaseType type, TrackPart trackPart, double ray) {

//		super(position, type, trackPart, ray);
		type = BaseType.pure;
	}

	//káros hatások lekerülnek
	public void stepOn(Bot bot) {

		System.out.println("\t\t\t\t" + getClass().getName() + ":stepOn");

		//állapaota pure lesz
		bot.setState(RobotState.pure);
		//iránya változtatható
		bot.setDirectionMod(true);
		//sebessége változtatható
		bot.setVeloMod(true);
	}
}