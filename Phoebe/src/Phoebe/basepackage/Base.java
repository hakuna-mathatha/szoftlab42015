package Phoebe.basepackage;
import Phoebe.gamepackage.Bot;
import Phoebe.trackpackage.Coordinate;
import Phoebe.trackpackage.TrackPart;
import java.sql.Timestamp;

public abstract class Base extends Observable {

	protected Coordinate position;
	protected BaseType type;
	protected TrackPart trackPart;
	protected double ray;
	
	protected Timestamp timeStamp;

	public Coordinate getPosition() { return position; }

	public void setPosition(Coordinate position) { this.position = position; }

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	public TrackPart getTrackPart() { return trackPart; }

	public void setTrackPart(TrackPart trackPart) { this.trackPart = trackPart; }

	public abstract void stepOn(Bot bot);

	public boolean isCoordNear(Coordinate coord) {

		//kevesebb lekerdezesre van szukseg
		double tmpX = coord.getX();
		double tmpY = coord.getY();
		double tmpPX = position.getX();
		double tmpPY = position.getY();

		//ha a koordinatak tavolsaga paronkent kisebb, mint a hatosugar, akkor a hatarteruleten van (negyzet alaku), a hatarok is szamitanak
		if (Math.abs(tmpX - tmpPX) < ray && Math.abs(tmpY - tmpPY) < ray) {
			return true;
		}
		return false;           //ha messzebb vannak egymastol nincs kolcsonhatas
	}

	public BaseType getType() {
		return type;
	}
	
	public synchronized void clean() {
        detachObserver();      //Observer levalasztasa
		trackPart.removeFromTrackPart(this);
	}
}
