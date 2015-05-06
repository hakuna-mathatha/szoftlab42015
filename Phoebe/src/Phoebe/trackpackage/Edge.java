package Phoebe.trackpackage;

import Phoebe.basepackage.BaseType;
import Phoebe.gamepackage.Bot;
import Phoebe.gamepackage.Displacement;
import Phoebe.gamepackage.RobotState;

import java.sql.Timestamp;

public class Edge extends Barrier {

	public Edge() {
		this.type = BaseType.edge;
		this.ray = 10;
		this.timeStamp = new Timestamp(System.currentTimeMillis());
		this.type = BaseType.edge;
	}

	public Edge(Coordinate position, TrackPart trackPart) {

		this.position = position;
		this.trackPart = trackPart;
	}

	//let�rt a p�ly�r�l, meg�ll, meghal
	public void stepOn(Bot bot) {

//		System.out.println("\t\t\t\t" + getClass().getName() + ":stepOn");

		//�llapaota edge lesz
		bot.setState(RobotState.died);
		//ir�nya nem v�ltoztathat�
		bot.setDirectionMod(false);
		//sebess�ge nem v�ltoztathat�
		bot.setVeloMod(false);
		//robot elmozdul�s�nak lek�r�se
		Displacement displacement = bot.getDisplacement();
		//elmozdul�s lenull�z�sa
		displacement.setVelocity(0);
		//�j elmozdul�s vissza�ll�t�sa
		bot.setDisplacement(displacement);

		//t�r�lj�k a robotot arr�l a p�lyaelemr�l, amin tart�zkodik, de a Game list�j�ban benne hagyjuk
		bot.getTrackPart().removeFromTrackPart(bot);
                bot.detachObserver();
	}
}