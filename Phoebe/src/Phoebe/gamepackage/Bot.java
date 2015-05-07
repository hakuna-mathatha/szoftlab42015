package Phoebe.gamepackage;
import Phoebe.basepackage.Base;
import Phoebe.trackpackage.Coordinate;
import Phoebe.trackpackage.Track;
import Phoebe.trackpackage.TrackPart;

public abstract class Bot extends Base {

	protected Displacement displacement;
	protected RobotState state;
	protected Coordinate nextPosition;
	protected Coordinate lastPosition;
	boolean veloMod;
	boolean directionMod;

	public Coordinate getLastPosition() {
		return lastPosition;
	}

	public void setLastPosition(Coordinate lastPosition) {
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
	}

	public void setPosition(Coordinate position1) {
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
	}

	public synchronized void setDisplacement(Displacement displacement1) {
		this.displacement = displacement1;
	}

	public Displacement getDisplacement() {
		return displacement;
	}

	public void setState(RobotState state1) {
		this.state = state1;
	}

	public RobotState getState() {
		return state;
	}

	@Override
	public abstract void stepOn(Bot aBot);

	protected void getTheEffectForRobot(Base barrier) {
		barrier.stepOn(this);
	}

	// Ay elmozdulas az aktualis ponttol nezve van ertemezve.
	public Coordinate calcCoordinate(Coordinate coord, Displacement disp) {
		Coordinate coordinate = new Coordinate();
		// Vesszuk az elozo pont es az aktualis pont kulonbseget, akkor kapjuk az elozo elmozdulas vektort,es ehez kepest szamoljuk az elfordulast rad ban. Az elmozdulas
		// magysaga az elozo elmozdulad nagysagaval megyezik kezdetben es ezt lehet modositani ami egy skalarral valo szorzas a gomb lenyomasanak fuggvenyeben

		Coordinate direction = new Coordinate();
		direction.setX(coord.getX() - lastPosition.getX());
		direction.setY(coord.getY() - lastPosition.getY());
		Coordinate dirNorm = new Coordinate();
		double leng = direction.legth();

		System.out.println(leng); //kivennimajd

		Coordinate rotation = new Coordinate();
		rotation.x = (direction.x * Math.cos(disp.getAngle()) - direction.y * Math.sin(disp.getAngle()));
		rotation.y = (direction.y * Math.cos(disp.getAngle()) + direction.x * Math.sin(disp.getAngle()));

		dirNorm.normal(rotation);

		double velo = disp.getVelocity();
		System.out.println("velo"+" "+velo);  //kivenni majd
		// Ha le van tiltva a sebesseg modositas, akkor a velo=1 legyen mert az elozo elmozdulas-t nem modosithatja

		leng = leng+velo;
		System.out.println(leng); //kivenni

		coordinate.setX(coord.x + leng * dirNorm.x );
		coordinate.setY(coord.y + leng * dirNorm.y );
		return coordinate;
	}

	protected Base giveMeTheBase(Coordinate coord, TrackPart part) {
		Base base = part.getBase(coord);
		return base;
	}
}