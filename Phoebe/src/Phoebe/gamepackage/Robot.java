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
		System.out.println("\t"+getClass().getName()+":Robot");
	}
	
	
	
	public void reducePuttyRepository() {
//		throw new UnsupportedOperationException();
		System.out.println("\t"+getClass().getName()+":reducePuttyRepository");
	}

	/**
	 * 
	 * @return 
	 */
	public void reduceOilRepository() {
//		throw new UnsupportedOperationException();
		System.out.println("\t"+getClass().getName()+":reduceOilRepository");
		
	}

	/**
	 * 
	 * @param distance
	 * @return 
	 */
	public void setDistance(double distance) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @return 
	 */
	public double getDistance() {
//		throw new UnsupportedOperationException();
		System.out.println("\t\t"+getClass().getName()+":getDistance");
		return 0;
	}

	/**
	 * 
	 * @param barrier
	 * @return 
	 */
	private void getTheEffectForRobot(Barrier barrier) {
//		throw new UnsupportedOperationException();
		System.out.println("\t"+getClass().getName()+":getTheEffectForRobot");
        barrier.setState(this);
		barrier.modifyDisplacement(this);
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
//		throw new UnsupportedOperationException();
		System.out.println("\t"+getClass().getName()+":giveMeTheBarrier");
		Barrier b = part.getBarrier(coord);
		return b;
	}

	/**
	 * 
	 * @param coord
	 * @param disp
	 * @return 
	 */
//	Alapbol privat de hogy a Helper elerje publicra kell rakni
	public Coordinate calcCoordinate(Coordinate coord, Displacement disp) {
//		throw new UnsupportedOperationException();
		System.out.println("\t"+getClass().getName()+":calcCoordinate");
		return null;
	}
	//dsf
	
	@Override
	public void jump(Track track){
//		throw new UnsupportedOperationException();
		System.out.println("\t"+getClass().getName()+":jump");
		calcCoordinate(position, displacement);
		TrackPart part = track.findAPart(position);
		Barrier b = giveMeTheBarrier(position, part);
		getTheEffectForRobot(b);
	}

}