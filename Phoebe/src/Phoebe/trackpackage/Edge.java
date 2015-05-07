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

	//letert a palyarol, megallt, meghal
	public void stepOn(Bot bot) {
		bot.setState(RobotState.died);    //allapaota edge lesz
		bot.setDirectionMod(false);       //iranya nem valtoztathato
		bot.setVeloMod(false);             //sebessege nem valtoztathato
		Displacement displacement = bot.getDisplacement();    //robot elmozdulasanak lekerdezese
		displacement.setVelocity(0);            //elmozdulas lenullazasa
		bot.setDisplacement(displacement);      //uj elmozdulas visszaallitasa
		bot.getTrackPart().removeFromTrackPart(bot);//taroljukk a robotot arrol a palyaelemrol, amin tartozkodik, de a Game listajaban benne hagyjuk
                bot.detachObserver();
	}
}