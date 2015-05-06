package Phoebe.basepackage;
import java.sql.Timestamp;

import Phoebe.gamepackage.*;
import Phoebe.trackpackage.*;

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

//		System.out.println("\t\t\t" + getClass().getName() + ":isCoordNear");

		//így kevesebb lekérdezésre van szükség
		double tmpX = coord.getX();
		double tmpY = coord.getY();
		double tmpPX = position.getX();
		double tmpPY = position.getY();

		//ha a koordináták távolsága páronként kisebb, mint a hatósugár, akkor a hatóterületén van (négzet alakú), a határok is számítanak
		if (Math.abs(tmpX - tmpPX) < ray && Math.abs(tmpY - tmpPY) < ray) {
//		if ((tmpX >= tmpPX && tmpX < (tmpPX + ray)) && (tmpY >= tmpPY && tmpY < (tmpPY + ray))) {
			return true;
		}

		//ha messzebb vannak egymástól, akkor nincs kölcsönhatás
		return false;
	}

	public BaseType getType() {

//		System.out.println("\t\t" + getClass().getName() + ":getType()");
		return type;
	}
	
	public synchronized void clean() {
//		System.out.println("\t\t\t" + getClass().getName() + ":clean");

		
		//Observer leválasztása
		detachObserver();
		trackPart.removeFromTrackPart(this);

	}
		
}
