package Phoebe.trackpackage;

import Phoebe.basepackage.BaseType;
import Phoebe.gamepackage.Bot;
import Phoebe.gamepackage.Displacement;
import Phoebe.gamepackage.RobotState;

public class Putty extends Barrier {

	private int countToRemove;

	public Putty() {}

	public Putty(Coordinate position, BaseType type, TrackPart trackPart, double ray) {

		super(position, type, trackPart, ray);
		type = BaseType.putty;
		//4 r�l�p�s ut�n t�nik el a ragacs a p�ly�r�l
		countToRemove = 4;
	}

	public int getCountToRemove() {
		return countToRemove;
	}

	public void setCountToRemove(int countToRemove) {
		this.countToRemove = countToRemove;
	}

	//ha ragacsba l�p�nk, felez�dik a sebess�g, �s nem v�ltoztathatjuk sebess�get a k�vetkez� k�rig
	public void stepOn(Bot bot) {

		System.out.println("\t\t\t\t" + getClass().getName() + ":stepOn");

		//cs�kkentj�k a tart�ss�g�t
		countToRemove--;

		//csak a norm�l robotra hat
		if (bot.getType() == BaseType.normalRobot) {
			//�llapaota putty lesz
			bot.setState(RobotState.putty);
			//ir�nya v�ltoztathat�
			bot.setDirectionMod(true);
			//sebess�ge nem v�ltoztathat�
			bot.setVeloMod(false);
			//robot elmozdul�s�nak lek�r�se
			Displacement displacement = bot.getDisplacement();
			//elmozdul�s hossz�nak fel�re cs�kkent�se
			displacement.setVelocity(displacement.getVelocity() / 2);
			//�j elmozdul�s vissza�ll�t�sa
			bot.setDisplacement(displacement);
		}

		// ha ez volt az utls� r�l�p�s, akkor elt�nik a p�ly�r�l
		if (countToRemove == 0) {
			trackPart.removeFromTrackPart(this);
		}
	}
}