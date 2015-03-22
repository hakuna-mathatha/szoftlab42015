package Phoebe.gamepackage;

import Phoebe.trackpackage.*;

public abstract class Bot {

	protected Displacement displacement;
	protected Coordinate position;
	protected RobotState state;
	protected TrackPart actualPart;
	protected Coordinate nextPosition;

	public abstract void jump(Track track);

	public void modifyDisplacement(Displacement disp) {
		System.out.println("\t\t\t"+getClass().getName()+":modifyDisplacement");
	}

	public void setPosition(Coordinate position) {
		System.out.println("\t\t\t"+getClass().getName()+":setPosition");
	}

	public Coordinate getPosition() {throw new UnsupportedOperationException();}

	public Coordinate getNextPosition() {throw new UnsupportedOperationException();}

	public void setNextPosition(Coordinate nextPosition) {};

	public void setDisplacement(Displacement displacement) {};

	public Displacement getDisplacement() {
        System.out.println("\t\t\t"+getClass().getName()+":getDisplacement");
        return displacement;
	}


	public void putTheBarrier(Coordinate coord, Barrier barrier, JumpablePart part) {
		System.out.println("\t"+getClass().getName()+":putTheBarrier");
		part.addBarrier(barrier, coord);
		
	}

	public TrackPart getActualPart() {throw new UnsupportedOperationException();}

	public void setActualPart(TrackPart actualPart) {};

	public void setState(RobotState state) {
        System.out.println("\t\t\t"+getClass().getName()+":setState");
	}

	public RobotState getState() {
		throw new UnsupportedOperationException();
	}

}