package Phoebe.gamepackage;

import javax.annotation.PostConstruct;

import Phoebe.basepackage.*;
import Phoebe.trackpackage.*;

import java.lang.Math;

public abstract class Bot extends Base {

	protected Displacement displacement;
	// protected Coordinate position;
	protected RobotState state;
	// protected TrackPart actualPart;
	protected Coordinate nextPosition;
	protected Coordinate lastPosition;
	boolean veloMod;
	boolean directionMod;

	public Coordinate getLastPosition() {
//		System.out.println("\t\t\t" + getClass().getName() + ":getLastPosition");
		return lastPosition;
	}

	public void setLastPosition(Coordinate lastPosition) {
//		System.out.println("\t\t\t" + getClass().getName() + ":setLastPosition");
		this.lastPosition = lastPosition;
	}
	
	public boolean getVeloMod() {
		return veloMod;
	}

	public void setVeloMod(boolean veloMod) { this.veloMod = veloMod; }

	public boolean getDirectionMod() {
		return directionMod;
	}

	public void setDirectionMod(boolean directionMod) {
		this.directionMod = directionMod;
	}

	public abstract void jump(Track track);

	public void modifyDisplacement(Displacement disp) {
//		System.out.println("\t\t\t" + getClass().getName() + ":modifyDisplacement");
	}

	public void setPosition(Coordinate position1) {
//		System.out.println("\t\t\t" + getClass().getName() + ":setPosition");
		this.position = position1;
	}

	public Coordinate getPosition() {
//		System.out.println("\t\t\t" + getClass().getName() + ":getPosition");
		return position;
	}

	public Coordinate getNextPosition() {
		//System.out.println("\t\t\t" + getClass().getName() + ":getNextPosition");
		return nextPosition;
	}

	public void setNextPosition(Coordinate nextPosition1) {
//		System.out.println("\t\t\t" + getClass().getName() + ":setNextPosition");
		this.nextPosition = nextPosition1;
	};

	public void setDisplacement(Displacement displacement1) {
//		System.out.println("\t\t\t" + getClass().getName() + ":setDisplacement");
		this.displacement = displacement1;
	}

	public Displacement getDisplacement() {
//		System.out.println("\t\t\t" + getClass().getName() + ":getDisplacement");
		return displacement;
	}

	public void setState(RobotState state1) {
	
		this.state = state1;
//		System.out.println("\t\t\t" + getClass().getName() + ":setState"+": "+this.state);
	}

	public RobotState getState() {
		return state;
	}

	@Override
	public abstract void stepOn(Bot aBot);

	protected void getTheEffectForRobot(Base barrier) {
//		System.out.println("\t" + getClass().getName() + ":getTheEffectForRobot");
		barrier.stepOn(this);

	}

	// Ay elmozdulas az aktualis ponttol nezve van ertemezve.
	public Coordinate calcCoordinate(Coordinate coord, Displacement disp) {
		Coordinate coordinate = new Coordinate();
		// Vesszuk az elozo pont es az aktualis pont kulonbseget, akkor kapjuk
		// az elozo elmozdulas vektort,
		// es ehez kepest szamoljuk az elfordulast rad ban. Az elmozdulas
		// magysaga az elozo elmozdulad nagysagaval
		// megyezik kezdetben es ezt lehet modositani ami egy skalarral valo
		// szorzas a gomb lenyomasanak fuggvenyeben

		Coordinate direction = new Coordinate();
		direction.setX(coord.getX() - lastPosition.getX());
		direction.setY(coord.getY() - lastPosition.getY());

//		 System.out.println("x: "+direction.getX() + " y: "+direction.getY());

		Coordinate dirNorm = new Coordinate();

		double leng = direction.legth();

//		System.out.println(leng);

		Coordinate rotation = new Coordinate();

		rotation.x = (direction.x * Math.cos(disp.getAngle()) - direction.y * Math.sin(disp.getAngle()));
		rotation.y = (direction.y * Math.cos(disp.getAngle()) + direction.x * Math.sin(disp.getAngle()));

		dirNorm.normal(rotation);

		double velo = disp.getVelocity();

		// Ha le van tiltva a sebesseg modositas, akkor a velo=1 legyen mert az
		// elozo elmozdulas-t nem modosithatja
		if (veloMod == false)
			velo = 1;

		coordinate.setX(coord.x + leng * dirNorm.x * velo);
		coordinate.setY(coord.y + leng * dirNorm.y * velo);


//		System.out
//				.println((direction.getY() * Math.cos(disp.getAngle()) + direction.getX() * Math.sin(disp.getAngle())));

//		System.out.println("\t" + getClass().getName() + ":calcCoordinate");

		return coordinate;
	}

	protected Base giveMeTheBase(Coordinate coord, TrackPart part) {
//		System.out.println("\t" + getClass().getName() + ":giveMeTheBarrier");
		Base base = part.getBase(coord);
		return base;
	}

}