package Phoebe.gamepackage;

import javax.annotation.PostConstruct;

import Phoebe.basepackage.*;
import Phoebe.trackpackage.*;

public abstract class Bot extends Base {

	protected Displacement displacement;
	// protected Coordinate position;
	protected RobotState state;
	protected TrackPart actualPart;
	protected Coordinate nextPosition;

	public abstract void jump(Track track);

	public void modifyDisplacement(Displacement disp) {
		System.out.println("\t\t\t" + getClass().getName() + ":modifyDisplacement");
	}

	public void setPosition(Coordinate position1) {
		System.out.println("\t\t\t" + getClass().getName() + ":setPosition");
		this.position = position1;
	}

	public Coordinate getPosition() {
		return position;
	}

	public Coordinate getNextPosition() {
		return nextPosition;
	}

	public void setNextPosition(Coordinate nextPosition1) {
		this.nextPosition = nextPosition1;
	};

	public void setDisplacement(Displacement displacement1) {
		this.displacement = displacement1;
	};

	public Displacement getDisplacement() {
		System.out.println("\t\t\t" + getClass().getName() + ":getDisplacement");
		return displacement;
	}

	public void putTheBarrier(Coordinate coord, Barrier barrier, JumpablePart part) {
		System.out.println("\t" + getClass().getName() + ":putTheBarrier");
		part.addBase(barrier, coord);

	}

	public TrackPart getActualPart() {
		return actualPart;
	}

	public void setActualPart(TrackPart actualPart1) {
		this.actualPart = actualPart1;
	};

	public void setState(RobotState state1) {
		System.out.println("\t\t\t" + getClass().getName() + ":setState");
		this.state = state1;
	}

	public RobotState getState() {
		return state;
	}

	
	
	@Override
	public abstract void stepOn(Bot aBot);

	
	protected void getTheEffectForRobot(Base barrier) {
		System.out.println("\t"+getClass().getName()+":getTheEffectForRobot");
        barrier.stepOn(this);
		//barrier.setState(this);
		//barrier.modifyDisplacement(this);
	}
	
	// kell meg
	protected Coordinate calcCoordinate(Coordinate coord, Displacement disp){
		Coordinate coodrinate = new Coordinate();
		
		return coodrinate;
	}
	
	protected Base giveMeTheBase(Coordinate coord, TrackPart part) {
		System.out.println("\t"+getClass().getName()+":giveMeTheBarrier");
		Base base = part.getBase(coord);
		return base;
	}

}