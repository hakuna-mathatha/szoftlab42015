package Phoebe.basepackage;
import Phoebe.gamepackage.*;
import Phoebe.trackpackage.*;

public abstract class Base {
	protected Coordinate position;
	protected BaseType type;
	protected TrackPart trackPart;
	

	
	public Coordinate getPosition() {
		return position;
	}

	public void setPosition(Coordinate position) {
		this.position = position;
	}

	
	public TrackPart getTrackPart() {
		return trackPart;
	}

	public void setTrackPart(TrackPart trackPart) {
		this.trackPart = trackPart;
	}

	public Base() {
		
	}

	public abstract void stepOn(Bot aBot);

	public boolean isCoordNear(Coordinate aCoord) {
		System.out.println("\t\t\t" + getClass().getName() + ":isCoordNear");	
		return true;
	}

	public BaseType getType() {
		System.out.println("\t\t" + getClass().getName() + ":getType()");
		return type;
	}
		
}
