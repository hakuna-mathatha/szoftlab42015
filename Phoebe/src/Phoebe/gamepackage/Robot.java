package Phoebe.gamepackage;

import java.sql.Timestamp;

import Phoebe.basepackage.Base;
import Phoebe.basepackage.BaseType;
import Phoebe.painter.RobotPainter;
import Phoebe.trackpackage.*;

public class Robot extends Bot {

	private int puttyReporitory;
	private int oilRepository;
	private double distance;
	private double velocityMod;
	private int id;
	


	public Robot(int id) {
//		System.out.println("\t" + getClass().getName() + ":Robot");
		puttyReporitory = 5;
		oilRepository = 5;
		distance = 0;
		velocityMod = 1;
		displacement = new Displacement(0.1, 1);
		state = RobotState.pure;
		// legyen a kiindulo ponttal azonos
		nextPosition = new Coordinate(1, 1);
		position = new Coordinate(1, 1);
		lastPosition = new Coordinate(0.5, 0.5);
		type = BaseType.normalRobot;
		trackPart = new JumpablePart(new Coordinate(1, 1), 4, 4);
		this.timeStamp = new Timestamp(System.currentTimeMillis());
		veloMod = true;
		directionMod = true;
		this.id=id;

		//Painter hozzáadása
		RobotPainter robotPainter = new RobotPainter(System.getProperty("user.dir") + "\\resources\\robot" + id + "_v1");
		attachObserver(robotPainter);
	}
	
	public Robot(Coordinate position1, Displacement disp1, Coordinate lastpos1, int id) {
//		System.out.println("\t" + getClass().getName() + ":Robot");
		puttyReporitory = 5;
		oilRepository = 5;
		distance = 0;
		velocityMod = 1;
		displacement = disp1;
		state = RobotState.pure;
		// legyen a kiindulo ponttal azonos
		nextPosition = new Coordinate(1, 1);
		position = position1;
		lastPosition = lastpos1;
		type = BaseType.normalRobot;
		trackPart = new JumpablePart();
		this.timeStamp = new Timestamp(System.currentTimeMillis());
		veloMod = true;
		directionMod = true;
		this.id=id;

		//Painter hozzáadása
		RobotPainter robotPainter = new RobotPainter(System.getProperty("user.dir") + "\\resources\\robot" + id + "_v1");
		attachObserver(robotPainter);
	}
	
	public Robot(Displacement disp1, int id) {
//		System.out.println("\t" + getClass().getName() + ":Robot");
		puttyReporitory = 5;
		oilRepository = 5;
		distance = 0;
		velocityMod = 1;
		displacement = disp1;
		state = RobotState.pure;
		// legyen a kiindulo ponttal azonos
		nextPosition = new Coordinate(1, 1);
		position = new Coordinate(1, 1);
		lastPosition = new Coordinate(0.5, 0.5);
		type = BaseType.normalRobot;
		trackPart = new JumpablePart();
		this.timeStamp = new Timestamp(System.currentTimeMillis());
		veloMod = true;
		directionMod = true;
		this.id=id;
		
		
		

		//Painter hozzáadása
		RobotPainter robotPainter = new RobotPainter(System.getProperty("user.dir") + "\\resources\\robot" + id + "_v1");
		attachObserver(robotPainter);
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void reducePuttyRepository() {
//		System.out.println("\t\t\t" + getClass().getName() + ":reducePuttyRepository");
		--puttyReporitory;
	}

	public void reduceOilRepository() {
//		System.out.println("\t\t\t" + getClass().getName() + ":reduceOilRepository");
		--oilRepository;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getDistance() {
//		System.out.println("\t\t" + getClass().getName() + ":getDistance");
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
		
//		System.out.println("\n"+"\t" + getClass().getName() + ":jump");
		veloMod = true;
		setState(RobotState.jump);
		setLastPosition(position);
		setPosition(nextPosition);

		trackPart.removeFromTrackPart(this);
		TrackPart part = track.findAPart(position);
		this.setTrackPart(part);
		Base b = giveMeTheBase(position, part);
		part.addBase(this, position);
		
		System.out.println("Itt vagyok: "+ position.x+" "+position.y+" "+id);
		
		displacement.angle = 0;
		displacement.velocity = 1;
		getTheEffectForRobot(b);
		
	}

	@Override
	public void stepOn(Bot aBot) {
//		System.out.println("\t" + getClass().getName() + ":stepOn()");
		// Atlag sebesseget ugy ertelmeztem, hogy a ket elmozdulas vektor
		// osszege altal kapott vektor hosszanak a fele
		if (aBot.getType().equals(BaseType.normalRobot)) {

			Displacement fast = new Displacement();

			Coordinate faster = new Coordinate();
			faster = aBot.getPosition().difCoord(aBot.getLastPosition());
			
			System.out.println("Faster: "+faster.getX()+" " + faster.getY()+"\n");
			

			Coordinate slower = new Coordinate();
			slower = this.getPosition().difCoord(this.getLastPosition());
			System.out.println("Slower: "+ slower.getX()+" " + slower.getY()+"\n");

			Coordinate sum = new Coordinate();
			sum = slower.addCoord(faster);
			System.out.println("Sum: "+ sum.getX()+" " + sum.getY()+"\n");
			double velo = sum.legth() / 2;
			System.out.println("Velo: "+velo);
			
			fast = aBot.getDisplacement();

			fast.setVelocity(velo);
			
			aBot.setDisplacement(fast);
			
			System.out.println(aBot.getDisplacement().getVelocity());
		
			
			// Tiltsa le a sebesseg modositas lehetoseget
			aBot.setVeloMod(false);
			aBot.setState(RobotState.active);
			
			this.trackPart.removeFromTrackPart(this);
			this.setState(RobotState.died);

		} else if (aBot.getType().equals(BaseType.cleanerRobot)) {
			Displacement disp = new Displacement();
			disp = aBot.getDisplacement();
			double velocity = aBot.getDisplacement().getVelocity();
			disp.setVelocity(velocity * (-1));

			aBot.setDisplacement(disp);
			
		}

	}

	public void putTheBarrier(Barrier barrier) {
//		System.out.println("\t" + getClass().getName() + ":putTheBarrier");

		BaseType type = barrier.getType();

		if (type.equals(BaseType.oil)) {
			if (oilRepository > 0) {
//				System.out.println("Rakok le olajat");
				trackPart.addBase(barrier, position);
				reduceOilRepository();
//				System.out.println(oilRepository);
				
			
			} else {
//				System.out.println("Out of " + barrier.getType());
			}

		} else if (type.equals(BaseType.putty)) {
			if (puttyReporitory > 0) {
				trackPart.addBase(barrier, position);
				reducePuttyRepository();
			} else {
//				System.out.println("Out of putty");
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