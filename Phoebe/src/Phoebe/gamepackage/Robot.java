package Phoebe.gamepackage;
import Phoebe.basepackage.Base;
import Phoebe.basepackage.BaseType;
import Phoebe.painter.RobotPainter;
import Phoebe.trackpackage.*;
import java.sql.Timestamp;

public class Robot extends Bot {

	private int puttyReporitory;
	private int oilRepository;
	private double distance;
	private double velocityMod;
	private int id;

	public Robot(int id) {
		puttyReporitory = 5;
		oilRepository = 5;
		distance = 0;
		velocityMod = 1;
		displacement = new Displacement(0.1, 1);
		state = RobotState.pure;
		nextPosition = new Coordinate(1, 1); //azonos a kiinduloval
		position = new Coordinate(1, 1);
		lastPosition = new Coordinate(0.5, 0.5);
		type = BaseType.normalRobot;
		trackPart = new JumpablePart(new Coordinate(1, 1), 4, 4);
		this.timeStamp = new Timestamp(System.currentTimeMillis());
		veloMod = true;
		directionMod = true;
		this.id=id;
		//Painter hozzaadasa
		RobotPainter robotPainter = new RobotPainter(System.getProperty("user.dir") + "\\resources\\robot" + id + "_v1.png");
		attachObserver(robotPainter);
	}
	
	public Robot(Coordinate position1, Displacement disp1, Coordinate lastpos1, int id) {
		puttyReporitory = 5;
		oilRepository = 5;
		distance = 0;
		velocityMod = 1;
		displacement = disp1;
		state = RobotState.pure;
		nextPosition = new Coordinate(1, 1);  // legyen a kiindulo ponttal azonos
		position = position1;
		lastPosition = lastpos1;
		type = BaseType.normalRobot;
		trackPart = new JumpablePart();
		this.timeStamp = new Timestamp(System.currentTimeMillis());
		veloMod = true;
		directionMod = true;
		this.id=id;
		//Painter hozzaadasa
		RobotPainter robotPainter = new RobotPainter(System.getProperty("user.dir") + "\\resources\\robot" + id + "_v1.png");
		attachObserver(robotPainter);
	}
	
	public Robot(Coordinate position1,Displacement disp1, int id) {
		puttyReporitory = 5;
		oilRepository = 5;
		distance = 0;
		velocityMod = 1;
		displacement = disp1;
		state = RobotState.pure;
		nextPosition = new Coordinate(1, 1);// legyen a kiindulo ponttal azonos
		position = position1;
		lastPosition = new Coordinate(10, 10);
		type = BaseType.normalRobot;
		trackPart = new JumpablePart();
		this.timeStamp = new Timestamp(System.currentTimeMillis());
		veloMod = true;
		directionMod = true;
		this.id=id;
		this.ray = 30;
		//Painter hozzaadasa
		RobotPainter robotPainter = new RobotPainter(System.getProperty("user.dir") + "\\resources\\robot" + id + "_v1.png");
		attachObserver(robotPainter);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void reducePuttyRepository() {
		--puttyReporitory;
	}

	public void reduceOilRepository() {
		--oilRepository;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getDistance() {
		return distance;
	}

	public double getVelocityMod() {
		return velocityMod;
	}

	public void setVelocityMod(double velocityMod) {
		this.velocityMod = velocityMod;
	}
	
	public void calcNextPosition(){
		setNextPosition(calcCoordinate(position, displacement));
	}
	
	
	

	@Override
	public void jump(Track track) {
		veloMod = true;
		setState(RobotState.jump);
		setLastPosition(position);
		setPosition(nextPosition);
		trackPart.removeFromTrackPart(this);
		TrackPart part = track.findAPart(position);
		this.setTrackPart(part);
		Base b = giveMeTheBase(position, part);
		part.addBase(this, position);
		displacement.angle = 0;
		displacement.velocity = 1;
//		System.out.println(displacement.getVelocity()+"********************");   //kivenni
		getTheEffectForRobot(b);
//		System.out.println(displacement.getVelocity()+"********************");    //kivenni
		defaultNextPosition();
	}
	
	public void defaultNextPosition(){
		setNextPosition(calcCoordinate(position, displacement));
	}

	@Override
	public void stepOn(Bot aBot) {
		// Atlag sebesseget ugy ertelmeztem, hogy a ket elmozdulas vektor
		// osszege altal kapott vektor hosszanak a fele
		if (aBot.getType().equals(BaseType.normalRobot)) {
			aBot.setDisplacement(modifyVeloRpbot_Robot(aBot));
			
			// Tiltsa le a sebesseg modositas lehetoseget
			aBot.setVeloMod(false);
			aBot.setState(RobotState.active);
			this.trackPart.removeFromTrackPart(this);
			this.setState(RobotState.died);
			//Observer levalasztasa
			detachObserver();
		} else if (aBot.getType().equals(BaseType.cleanerRobot)) {
			System.out.println("ra ugrott");   //kivenni
			Displacement disp = new Displacement();
			disp = aBot.getDisplacement();
			double velocity = aBot.getDisplacement().getVelocity();
			disp.setVelocity(velocity * (-1));
			aBot.setDisplacement(disp);
		}
	}
	
	public Displacement modifyVeloRpbot_Robot(Bot robot){
		Displacement fast = new Displacement();
		Coordinate faster = new Coordinate();
		faster = robot.getPosition().difCoord(robot.getLastPosition());
//		System.out.println("Faster: "+faster.getX()+" " + faster.getY()+"\n");   ///kivenni
		Coordinate slower = new Coordinate();
		slower = this.getPosition().difCoord(this.getLastPosition());
//		System.out.println("Slower: "+ slower.getX()+" " + slower.getY()+"\n");  //kivenni
		Coordinate sum = new Coordinate();
		sum = slower.addCoord(faster);
//		System.out.println("Sum: "+ sum.getX()+" " + sum.getY()+"\n");  //kivenni
		double velo = sum.legth() / 2;
//		System.out.println("Velo: "+velo);   //kivenni
		Coordinate direction = new Coordinate();
		direction.setX(robot.getPosition().getX() - robot.getLastPosition().getX());
		direction.setY(robot.getPosition().getY() - robot.getLastPosition().getY());
		double leng = direction.legth();
//		System.out.println(robot.getDisplacement().getVelocity());  //kivenni
		Displacement displacement = robot.getDisplacement();
		displacement.setVelocity(-1*(leng-velo));
		return displacement;
	}

	public void putTheBarrier(Barrier barrier) {
		BaseType type = barrier.getType();
		if (type.equals(BaseType.oil)) {
			if ((oilRepository > 0) && ((getState() != RobotState.died))) {
				trackPart.addBase(barrier, position);
				reduceOilRepository();
			}
		} else if (type.equals(BaseType.putty)) {
			if ((puttyReporitory > 0 ) && (getState() != RobotState.died)) {
				trackPart.addBase(barrier, position);
				reducePuttyRepository();
				System.out.println("Putt putty");
			    }
			}
		}

    public int getOilRepository(){
        return this.oilRepository;
    }

    public int getPuttyRepository(){
        return this.puttyReporitory;
    }
}