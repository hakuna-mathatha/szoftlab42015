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
		System.out.println("	Robotpeldany letrehozasa");
	}
	
	
	
	public void reducePuttyRepository() {
//		throw new UnsupportedOperationException();
		System.out.println("	Leraktam egy ragacsot, csokken a keszlet");
	}

	/**
	 * 
	 * @return 
	 */
	public void reduceOilRepository() {
//		throw new UnsupportedOperationException();
		System.out.println("	Leraktam egy olajat, csokken a keszlet.");
		
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
		System.out.println("Robot tavolsaganak lekerese");
		return 0;
	}

	/**
	 * 
	 * @param barrier
	 * @return 
	 */
	private void getTheEffectForRobot(Barrier barrier) {
//		throw new UnsupportedOperationException();
		System.out.println("getTheEffectForRobot fgv hivas");
		barrier.modifyDisplacement(this);
		barrier.setState(this);
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
		System.out.println("Akadaly keresese az elemen");
		Barrier b = part.getBarrier(coord);
		return b;
	}

	/**
	 * 
	 * @param coord
	 * @param disp
	 * @return 
	 */
	private Coordinate calcCoordinate(Coordinate coord, Displacement disp) {
//		throw new UnsupportedOperationException();
		System.out.println("Robot koord szamolas");
		return null;
	}
	
	
	@Override
	public void jump(Track track){
//		throw new UnsupportedOperationException();
		System.out.println("Bot jump() hivason");
		calcCoordinate(position, displacement);
		TrackPart part = track.findAPart(position);
		Barrier b = giveMeTheBarrier(position, part);
		getTheEffectForRobot(b);
	}

}