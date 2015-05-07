package Phoebe.trackpackage;
import Phoebe.basepackage.BaseType;
import Phoebe.gamepackage.Bot;
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

	//koros hatasok lekerulnek
	public void stepOn(Bot bot) {
		bot.setState(RobotState.pure);      //allapaota pure lesz
		bot.setDirectionMod(true);          //iranya valtoztathato
		bot.setVeloMod(true);           //sebessege valtoztathato
	}
}