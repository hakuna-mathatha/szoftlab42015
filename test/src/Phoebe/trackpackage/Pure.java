package Phoebe.trackpackage;

import Phoebe.basepackage.BaseType;
import Phoebe.gamepackage.Bot;
import Phoebe.gamepackage.Displacement;
import Phoebe.gamepackage.RobotState;

import java.sql.Timestamp;

public class Pure extends Barrier {

	public Pure() {
		this.type = BaseType.pure;
		this.ray = 10;
		this.timeStamp = new Timestamp(System.currentTimeMillis());
		this.type = BaseType.pure;
	}

	public Pure(Coordinate position, TrackPart trackPart) {

		this.position = position;
		this.trackPart = trackPart;
	}

	//káros hatások lekerülnek
	public void stepOn(Bot bot) {

//		System.out.println("\t\t\t\t" + getClass().getName() + ":stepOn");

		//állapaota pure lesz
		bot.setState(RobotState.pure);
		//iránya változtatható
		bot.setDirectionMod(true);
		//sebessége változtatható
		bot.setVeloMod(true);
	}
}