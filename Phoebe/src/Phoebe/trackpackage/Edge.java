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

	//letért a pályáról, megáll, meghal
	public void stepOn(Bot bot) {

		System.out.println("\t\t\t\t" + getClass().getName() + ":stepOn");

		//állapaota edge lesz
		bot.setState(RobotState.died);
		//iránya nem változtatható
		bot.setDirectionMod(false);
		//sebessége nem változtatható
		bot.setVeloMod(false);
		//robot elmozdulásának lekérése
		Displacement displacement = bot.getDisplacement();
		//elmozdulás lenullázása
		displacement.setVelocity(0);
		//új elmozdulás visszaállítása
		bot.setDisplacement(displacement);

		//töröljük a robotot arról a pályaelemrõl, amin tartózkodik, de a Game listájában benne hagyjuk
		bot.getTrackPart().removeFromTrackPart(bot);
	}
}