package Phoebe.gamepackage;

import Phoebe.trackpackage.*;

public class Robot extends Bot {

	private int puttyReporitory;
	private int oilRepository;
	private double distance;
	private double velocityMod;

	public Robot(){
		System.out.println("\t"+getClass().getName()+":Robot");
	}

	public void reducePuttyRepository() {
		System.out.println("\t"+getClass().getName()+":reducePuttyRepository");
	}

	public void reduceOilRepository() {
		System.out.println("\t"+getClass().getName()+":reduceOilRepository");
	}

	public void setDistance(double distance) {};

	public double getDistance() {
		System.out.println("\t\t"+getClass().getName()+":getDistance");
		return 0;
	}

	private void getTheEffectForRobot(Barrier barrier) {
		System.out.println("\t"+getClass().getName()+":getTheEffectForRobot");
        barrier.setState(this);
		barrier.modifyDisplacement(this);
	}

	public double getVelocityMod(){throw new UnsupportedOperationException();}

	public void setVelocityMod(double velocityMod){};

	private Barrier giveMeTheBarrier(Coordinate coord, TrackPart part) {
		System.out.println("\t"+getClass().getName()+":giveMeTheBarrier");
		Barrier b = part.getBarrier(coord);
		return b;
	}

//	Alapbol privat de hogy a Helper elerje publicra kell rakni
	public Coordinate calcCoordinate(Coordinate coord, Displacement disp) {
		System.out.println("\t"+getClass().getName()+":calcCoordinate");
		return null;
	}
	
	@Override
	public void jump(Track track){
		System.out.println("\t"+getClass().getName()+":jump");
		calcCoordinate(position, displacement);
		TrackPart part = track.findAPart(position);
		Barrier b = giveMeTheBarrier(position, part);
		getTheEffectForRobot(b);
	}

}