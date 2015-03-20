package Phoebe.gamepackage;


import Phoebe.gamepackage.*;
import Phoebe.trackpackage.*;

public abstract class Bot {

	protected Displacement displacement;
	protected Coordinate position;
	protected RobotState state;
	protected TrackPart actualPart;
	protected Coordinate nextPosition;
	
	

	/**
	 * 
	 * @param track
	 * @return 
	 */
	public abstract void jump(Track track);

	/**
	 * 
	 * @param disp
	 * @return 
	 */
	public void modifyDisplacement(Displacement disp) {
		//throw new UnsupportedOperationException();
		System.out.println("\t\t\t"+getClass().getName()+":modifyDisplacement");
	}

	/**
	 * 
	 * @param position
	 * @return 
	 */
	public void setPosition(Coordinate position) {
		//throw new UnsupportedOperationException();
		System.out.println("\t\t\t"+getClass().getName()+":setPosition");
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
        //throw new UnsupportedOperationException();
        System.out.println("\t\t\t"+getClass().getName()+":getDisplacement");
        return displacement;
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
		System.out.println("\t"+getClass().getName()+":putTheBarrier");
		part.addBarrier(barrier, coord);
		
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
		//throw new UnsupportedOperationException();
        System.out.println("\t\t\t"+getClass().getName()+":setState");
	}

	/**
	 * 
	 * @return 
	 */
	public RobotState getState() {
		throw new UnsupportedOperationException();
	}

}