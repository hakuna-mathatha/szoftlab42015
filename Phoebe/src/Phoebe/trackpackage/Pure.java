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

	//k�ros hat�sok leker�lnek
	public void stepOn(Bot bot) {

		System.out.println("\t\t\t\t" + getClass().getName() + ":stepOn");

		//�llapaota pure lesz
		bot.setState(RobotState.pure);
		//ir�nya v�ltoztathat�
		bot.setDirectionMod(true);
		//sebess�ge v�ltoztathat�
		bot.setVeloMod(true);
	}
}