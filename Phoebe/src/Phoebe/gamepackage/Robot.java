package Phoebe.gamepackage;

import Phoebe.basepackage.Base;
import Phoebe.basepackage.BaseType;
import Phoebe.trackpackage.*;

public class Robot extends Bot {

	private int puttyReporitory;
	private int oilRepository;
	private double distance;
	private double velocityMod;

	public Robot() {
		System.out.println("\t" + getClass().getName() + ":Robot");
		puttyReporitory = 5;
		oilRepository = 5;
		distance = 0;
		velocityMod = 1;
		displacement = new Displacement((-1)*Math.PI, 1);
		state = RobotState.pure;
		// legyen a kiindulo ponttal azonos
		nextPosition = new Coordinate(1, 1);
		position = new Coordinate(1,1);
		lastPosition = new Coordinate(0.5,0.5);
		type = BaseType.normalRobot;
		trackPart = new JumpablePart();
		
	}

	public void reducePuttyRepository() {
		System.out.println("\t\t\t" + getClass().getName() + ":reducePuttyRepository");
		--puttyReporitory;
	}

	public void reduceOilRepository() {
		System.out.println("\t\t\t" + getClass().getName() + ":reduceOilRepository");
		--oilRepository;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getDistance() {
		System.out.println("\t\t" + getClass().getName() + ":getDistance");
		return distance;
	}


	public double getVelocityMod() {
		return velocityMod;
	}

	public void setVelocityMod(double velocityMod) {
		this.velocityMod = velocityMod;
	}



	@Override
	public void jump(Track track) {
		setState(RobotState.jump);
		System.out.println("\t" + getClass().getName() + ":jump");

		setNextPosition(calcCoordinate(position, displacement));
		setLastPosition(position);
		setPosition(nextPosition);

		trackPart.removeFromTrackPart(this);
		TrackPart part = track.findAPart(position);
		this.setTrackPart(part);
		Base b = giveMeTheBase(position, part);
		part.addBase(this, position);

		getTheEffectForRobot(b);
	}

	@Override
	public void stepOn(Bot aBot) {
		System.out.println("Robot stepOn");

		if (aBot.getType().equals(BaseType.normalRobot)) {

			Displacement fast = new Displacement();

			Coordinate faster = new Coordinate();
			faster = this.getLastPosition().difCoord(this.getPosition());

			Coordinate slower = new Coordinate();
			slower = this.getLastPosition().difCoord(aBot.getPosition());

			Coordinate avg = new Coordinate();
			avg = slower.addCoord(faster);

			double velo = Math.sqrt(Math.pow(avg.getX(), 2) + Math.pow(avg.getY(), 2)) / 2;

			fast = aBot.getDisplacement();

			fast.setVelocity(velo);

			aBot.setDisplacement(fast);

			this.trackPart.removeFromTrackPart(this);
			this.state = RobotState.died;

		} else if (aBot.getType().equals(BaseType.cleanerRobot)) {
			Displacement disp = new Displacement();
			disp = aBot.getDisplacement();
			double velocity = aBot.getDisplacement().getVelocity();
			disp.setVelocity(velocity * (-1));

			aBot.setDisplacement(disp);

		}

	}
	
	public void putTheBarrier(Barrier barrier) {
		System.out.println("\t" + getClass().getName() + ":putTheBarrier");
		
		BaseType type = barrier.getType();
		
		if(type.equals(BaseType.oil)){

			if(oilRepository>0){
				reduceOilRepository();
;
				trackPart.addBase(barrier, position);
			}else{
				System.out.println("Out of oil");
			}
			
		}else if(type.equals(BaseType.putty)){
			
			if(puttyReporitory>0){
				reducePuttyRepository();
				trackPart.addBase(barrier, position);
			}else{
				System.out.println("Out of putty");
			}
		
		}


	}

}