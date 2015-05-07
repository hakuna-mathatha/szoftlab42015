package Phoebe.trackpackage;
import Phoebe.basepackage.BaseType;
import Phoebe.gamepackage.Bot;
import Phoebe.gamepackage.Displacement;
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
		countToRemove = 4;          //4 ralepess utan tunik el a ragacs a palyarol

		//Painter hozzaadasa
		PuttyPainter puttyPainter = new PuttyPainter(System.getProperty("user.dir") + "\\resources\\spill1_v1.png");
		attachObserver(puttyPainter);
	}

	public Putty(Coordinate position, TrackPart trackPart) {
		this.position = position;
		this.trackPart = trackPart;
		this.type = BaseType.putty;
		this.ray = 50.5;
		this.timeStamp = new Timestamp(System.currentTimeMillis());
		this.type = BaseType.putty;
		countToRemove = 4; /////4 ralepess utan tunik el a ragacs a palyarol

		//Painter hozzaadasa
		PuttyPainter puttyPainter = new PuttyPainter(System.getProperty("user.dir") + "\\resources\\spill1_v1.png");
		attachObserver(puttyPainter);
	}

	public int getCountToRemove() {
		return countToRemove;
	}

	public void setCountToRemove(int countToRemove) {
		this.countToRemove = countToRemove;
	}

	//ha ragacsba lepunk, felezodik a sebesseg, es nem valtoztathatjuk sebesseget a kovetkezo korig
	public void stepOn(Bot bot) {
		countToRemove--;    //csokkentjuk a tartossagot

		//csak a normal robotra hat
		if (bot.getType() == BaseType.normalRobot) {
			bot.setState(RobotState.putty);             //allapaota putty lesz
			bot.setDirectionMod(true);                  //iranya valtoztathato
			bot.setVeloMod(false);                      //sebessege nem valtoztathato
			bot.setDisplacement(modifyVelo(bot));       //uj elmozdulas visszaallitasa
			System.out.println("putttty********************"); //kivennii
		}else if(bot.getType() == BaseType.cleanerRobot){
			this.clean();
		}

		// ha ez volt az utlso ralepes, eltunik a palyarol
		if (countToRemove == 0) {
			this.clean();
		}
	}
	
	public Displacement modifyVelo(Bot bot){

			Bot robot = bot;
			Coordinate direction = new Coordinate();
			direction.setX(robot.getPosition().getX() - robot.getLastPosition().getX());
			direction.setY(robot.getPosition().getY() - robot.getLastPosition().getY());
			double leng = direction.legth();
			System.out.println("putttty********************"+leng);                //kivenni
			Displacement displacement = robot.getDisplacement();
			displacement.setVelocity(leng / (-2));
			System.out.println("putttty********************"+displacement.getVelocity());  //kivenni
			return displacement;
	}
}