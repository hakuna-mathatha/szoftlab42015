package Phoebe.trackpackage;

import Phoebe.basepackage.BaseType;
import Phoebe.gamepackage.Bot;
import Phoebe.gamepackage.Displacement;
import Phoebe.gamepackage.Robot;
import Phoebe.gamepackage.RobotState;
import Phoebe.painter.PuttyPainter;

import java.sql.Timestamp;

public class Putty extends Barrier {

	private int countToRemove;

	public Putty() {
		this.type = BaseType.putty;
		this.ray = 50.5;
		this.timeStamp = new Timestamp(System.currentTimeMillis());
		this.type = BaseType.putty;
		trackPart = new JumpablePart();
		position = new Coordinate(1,1);
		//4 r�l�p�s ut�n t�nik el a ragacs a p�ly�r�l
		countToRemove = 4;

		//Painter hozz�ad�sa
		PuttyPainter puttyPainter = new PuttyPainter(System.getProperty("user.dir") + "\\resources\\spill1_v1.png");
		attachObserver(puttyPainter);

//		System.out.println(getClass().getName() + ":Putty");
	}

	public Putty(Coordinate position, TrackPart trackPart) {

		this.position = position;
		this.trackPart = trackPart;
		this.type = BaseType.putty;
		this.ray = 50.5;
		this.timeStamp = new Timestamp(System.currentTimeMillis());
		this.type = BaseType.putty;
		//4 r�l�p�s ut�n t�nik el a ragacs a p�ly�r�l
		countToRemove = 4;

		//Painter hozz�ad�sa
		PuttyPainter puttyPainter = new PuttyPainter(System.getProperty("user.dir") + "\\resources\\spill1_v1.png");
		attachObserver(puttyPainter);

//		System.out.println(getClass().getName() + ":Putty");
	}

	public int getCountToRemove() {
		return countToRemove;
	}

	public void setCountToRemove(int countToRemove) {
		this.countToRemove = countToRemove;
	}

	//ha ragacsba l�p�nk, felez�dik a sebess�g, �s nem v�ltoztathatjuk sebess�get a k�vetkez� k�rig
	public void stepOn(Bot bot) {

//		System.out.println("\t\t\t\t" + getClass().getName() + ":stepOn");

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
//			Displacement displacement = bot.getDisplacement();
			//elmozdul�s hossz�nak fel�re cs�kkent�se
//			displacement.setVelocity(displacement.getVelocity() / 2);
			//�j elmozdul�s vissza�ll�t�sa
			bot.setDisplacement(modifyVelo(bot));
			
			System.out.println("putttty********************");
		}

		// ha ez volt az utls� r�l�p�s, akkor elt�nik a p�ly�r�l
		if (countToRemove == 0) {
			trackPart.removeFromTrackPart(this);

			//Observer lev�laszt�sa
			detachObserver();
		}
	}
	
	public Displacement modifyVelo(Bot bot){
			
			Bot robot = bot;
			
			
			Coordinate direction = new Coordinate();
			direction.setX(robot.getPosition().getX() - robot.getLastPosition().getX());
			direction.setY(robot.getPosition().getY() - robot.getLastPosition().getY());
			double leng = direction.legth();
			System.out.println("putttty********************"+leng);
			Displacement displacement = robot.getDisplacement();
			
			displacement.setVelocity(leng / (-2));
			System.out.println("putttty********************"+displacement.getVelocity());
			return displacement;
		
	}
}