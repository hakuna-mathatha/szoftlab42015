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
		//4 rálépés után tûnik el a ragacs a pályáról
		countToRemove = 4;

		//Painter hozzáadása
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
		//4 rálépés után tûnik el a ragacs a pályáról
		countToRemove = 4;

		//Painter hozzáadása
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

	//ha ragacsba lépünk, felezõdik a sebesség, és nem változtathatjuk sebességet a következõ körig
	public void stepOn(Bot bot) {

//		System.out.println("\t\t\t\t" + getClass().getName() + ":stepOn");

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
//			Displacement displacement = bot.getDisplacement();
			//elmozdulás hosszának felére csökkentése
//			displacement.setVelocity(displacement.getVelocity() / 2);
			//új elmozdulás visszaállítása
			bot.setDisplacement(modifyVelo(bot));
			
			System.out.println("putttty********************");
		}

		// ha ez volt az utlsó rálépés, akkor eltûnik a pályáról
		if (countToRemove == 0) {
			trackPart.removeFromTrackPart(this);

			//Observer leválasztása
			detachObserver();
		}
	}
	
	public Displacement modifyVelo(Bot bot){
			
			Robot robot = (Robot)bot;
			
			
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