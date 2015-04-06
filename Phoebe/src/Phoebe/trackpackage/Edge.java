package Phoebe.trackpackage;

import Phoebe.basepackage.BaseType;
import Phoebe.gamepackage.Bot;
import Phoebe.gamepackage.Displacement;
import Phoebe.gamepackage.RobotState;

public class Edge extends Barrier {

	public Edge() {}

	public Edge(Coordinate position, BaseType type, TrackPart trackPart, double ray) {

//		super(position, type, trackPart, ray);
		type = BaseType.edge;
	}

	//letért a pályáról, meghal
	public void stepOn(Bot bot) {

		System.out.println("\t\t\t\t" + getClass().getName() + ":stepOn");

		//állapaota edge lesz
		bot.setState(RobotState.died);
		//iránya nem változtatható
		bot.setDirectionMod(false);
		//sebessége nem változtatható
		bot.setVeloMod(false);

		//töröljük a robotot arról a pályaelemrõl, amin tartózkodik, de a Game listájában benne hagyjuk
		bot.getTrackPart().removeFromTrackPart(bot);
	}
}