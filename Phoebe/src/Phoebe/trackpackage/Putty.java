package Phoebe.trackpackage;

import Phoebe.basepackage.BaseType;
import Phoebe.gamepackage.Bot;
import Phoebe.gamepackage.Displacement;
import Phoebe.gamepackage.RobotState;

import java.sql.Timestamp;

public class Putty extends Barrier {

	private int countToRemove;

	public Putty() {
		this.type = BaseType.putty;
		this.ray = 10;
		this.timeStamp = new Timestamp(System.currentTimeMillis());
		this.type = BaseType.putty;
		//4 rálépés után tûnik el a ragacs a pályáról
		countToRemove = 4;

		System.out.println(getClass().getName() + ":Putty");
	}

	public Putty(Coordinate position, TrackPart trackPart) {

		this.position = position;
		this.trackPart = trackPart;

		System.out.println(getClass().getName() + ":Putty");
	}

	public int getCountToRemove() {
		return countToRemove;
	}

	public void setCountToRemove(int countToRemove) {
		this.countToRemove = countToRemove;
	}

	//ha ragacsba lépünk, felezõdik a sebesség, és nem változtathatjuk sebességet a következõ körig
	public void stepOn(Bot bot) {

		System.out.println("\t\t\t\t" + getClass().getName() + ":stepOn");

		//csökkentjük a tartósságát
		countToRemove--;

		//csak a normál robotra hat
		if (bot.getType() == BaseType.normalRobot) {
			//állapaota putty lesz
			bot.setState(RobotState.putty);
			//iránya változtatható
			bot.setDirectionMod(true);
			//sebessége nem változtatható
			bot.setVeloMod(false);
			//robot elmozdulásának lekérése
			Displacement displacement = bot.getDisplacement();
			//elmozdulás hosszának felére csökkentése
			displacement.setVelocity(displacement.getVelocity() / 2);
			//új elmozdulás visszaállítása
			bot.setDisplacement(displacement);
		}

		// ha ez volt az utlsó rálépés, akkor eltûnik a pályáról
		if (countToRemove == 0) {
			trackPart.removeFromTrackPart(this);
		}
	}
}