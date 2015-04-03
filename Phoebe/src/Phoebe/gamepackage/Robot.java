package Phoebe.gamepackage;

import Phoebe.basepackage.Base;
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

//	@Override
//	protected void getTheEffectForRobot(Base barrier) {
//		System.out.println("\t"+getClass().getName()+":getTheEffectForRobot");
//        barrier.stepOn(this);
//		//barrier.setState(this);
//		//barrier.modifyDisplacement(this);
//	}

	public double getVelocityMod(){throw new UnsupportedOperationException();}

	public void setVelocityMod(double velocityMod){};

//	@Override
//	protected Base giveMeTheBase(Coordinate coord, TrackPart part) {
//		System.out.println("\t"+getClass().getName()+":giveMeTheBarrier");
//		Base b = part.getBase(coord);
//		return b;
//	}

	// A Bot ban ez protected
	@Override
	public Coordinate calcCoordinate(Coordinate coord, Displacement disp) {
		System.out.println("\t"+getClass().getName()+":calcCoordinate");
		return null;
	}
	
	@Override
	public void jump(Track track){
		System.out.println("\t"+getClass().getName()+":jump");
		calcCoordinate(position, displacement);
		TrackPart part = track.findAPart(position);
		Base b = giveMeTheBase(position, part);
		getTheEffectForRobot(b);
	}

	@Override
	public void stepOn(Bot aBot) {
		// TODO Auto-generated method stub
		
	}

}