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
		displacement = new Displacement((-1) * Math.PI, 1);
		state = RobotState.pure;
		// legyen a kiindulo ponttal azonos
		nextPosition = new Coordinate(1, 1);
		position = new Coordinate(1, 1);
		lastPosition = new Coordinate(0.5, 0.5);
		type = BaseType.normalRobot;
		trackPart = new JumpablePart();

		veloMod = true;
		directionMod = true;

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
		veloMod = true;
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
		// Atlag sebesseget ugy ertelmeztem, hogy a ket elmozdulas vektor
		// osszege altal kapott vektor hosszanak a fele
		if (aBot.getType().equals(BaseType.normalRobot)) {

			Displacement fast = new Displacement();

			Coordinate faster = new Coordinate();
			faster = aBot.getPosition().difCoord(aBot.getLastPosition());

			Coordinate slower = new Coordinate();
			slower = this.getPosition().difCoord(this.getLastPosition());

			Coordinate sum = new Coordinate();
			sum = slower.addCoord(faster);

			double velo = sum.legth() / 2;

			fast = aBot.getDisplacement();

			fast.setVelocity(velo);

			aBot.setDisplacement(fast);
			// Tiltsa le a sebesseg modositas lehetoseget
			aBot.setVeloMod(false);
			aBot.setState(RobotState.active);
			
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

		if (type.equals(BaseType.oil)) {
			if (oilRepository > 0) {
				reduceOilRepository();
				trackPart.addBase(barrier, position);
				System.out.println(oilRepository);
			} else {
				System.out.println("Out of oil");
			}

		} else if (type.equals(BaseType.putty)) {
			if (puttyReporitory > 0) {
				reducePuttyRepository();
				trackPart.addBase(barrier, position);
			} else {
				System.out.println("Out of putty");
			}

		}

	}

}