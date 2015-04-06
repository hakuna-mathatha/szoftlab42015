package Phoebe.trackpackage;

import Phoebe.basepackage.BaseType;
import Phoebe.gamepackage.Bot;
import Phoebe.gamepackage.Displacement;
import Phoebe.gamepackage.RobotState;

public class Edge extends Barrier {

	public Edge() {}

	public Edge(Coordinate position, BaseType type, TrackPart trackPart, double ray) {

		super(position, type, trackPart, ray);
		type = BaseType.edge;
	}

	//let�rt a p�ly�r�l, meghal
	public void stepOn(Bot bot) {

		System.out.println("\t\t\t\t" + getClass().getName() + ":stepOn");

		//�llapaota edge lesz
		bot.setState(RobotState.died);
		//ir�nya nem v�ltoztathat�
		bot.setDirectionMod(false);
		//sebess�ge nem v�ltoztathat�
		bot.setVeloMod(false);

		//t�r�lj�k a robotot arr�l a p�lyaelemr�l, amin tart�zkodik, de a Game list�j�ban benne hagyjuk
		bot.getTrackPart().removeFromTrackPart(bot);
	}
}