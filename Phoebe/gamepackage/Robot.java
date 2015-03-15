package Phoebe.gamepackage;

import Phoebe.*;
import Phoebe.trackpackage.*;

public class Robot extends Bot {

	private int puttyReporitory;
	private int oilRepository;
	private double distance;
	private double velocityMod;

	/**
	 * 
	 * @return 
	 */
	public Robot(){
		System.out.println("	Robotpeldany letrehozasa.");
	}
	
	void reducePuttyRepository() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @return 
	 */
	void reduceOilRepository() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param distance
	 * @return 
	 */
	void setDistance(double distance) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @return 
	 */
	double getDistance() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param barrier
	 * @return 
	 */
	private void getTheEffectForRobot(Barrier barrier) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @return 
	 */
	public double getVelocityMod() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param velocityMod
	 * @return 
	 */
	public void setVelocityMod(double velocityMod) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param coord
	 * @param part
	 * @return 
	 */
	private Barrier giveMeTheBarrier(Coordinate coord, TrackPart part) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param coord
	 * @param disp
	 * @return 
	 */
	private Coordinate calcCoordinate(Coordinate coord, Displacement disp) {
		throw new UnsupportedOperationException();
	}

}