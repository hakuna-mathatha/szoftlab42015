package Phoebe.gamepackage;


import Phoebe.gamepackage.*;
import Phoebe.trackpackage.*;

public abstract class Bot {

	private Displacement displacement;
	private Coordinate position;
	private RobotState state;
	private TrackPart actualPart;
	private Coordinate nextPosition;

	/**
	 * 
	 * @param track
	 * @return 
	 */
	void jump(Track track) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param disp
	 * @return 
	 */
	public void modifyDisplacement(Displacement disp) {
		//throw new UnsupportedOperationException();
		System.out.println("Modositom a robot sebesseget");
	}

	/**
	 * 
	 * @param position
	 * @return 
	 */
	public void setPosition(Coordinate position) {
		//throw new UnsupportedOperationException();
		System.out.println("Modositom a robot allapotat");
	}

	/**
	 * 
	 * @return 
	 */
	public Coordinate getPosition() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @return 
	 */
	public Coordinate getNextPosition() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nextPosition
	 * @return 
	 */
	public void setNextPosition(Coordinate nextPosition) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param displacement
	 * @return 
	 */
	public void setDisplacement(Displacement displacement) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @return 
	 */
	public Displacement getDisplacement() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param coord
	 * @param barrier
	 * @param part
	 * @return 
	 */
	public void putTheBarrier(Coordinate coord, Barrier barrier, JumpablePart part) {
		//throw new UnsupportedOperationException();
		System.out.println("Barrier lerakas");
		part.addBarrier(barrier, coord);
		barrier.modifyDisplacement(this);
		barrier.setState(this);
	}

	/**
	 * 
	 * @return 
	 */
	public TrackPart getActualPart() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param actualPart
	 * @return 
	 */
	public void setActualPart(TrackPart actualPart) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param state
	 * @return 
	 */
	public void setState(RobotState state) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @return 
	 */
	public RobotState getState() {
		throw new UnsupportedOperationException();
	}

}