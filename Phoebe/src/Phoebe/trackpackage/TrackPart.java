package Phoebe.trackpackage;
import Phoebe.basepackage.*;
public abstract class TrackPart {

	private Coordinate position;
	private double width;
	private double height;

	double getWidth() {
		throw new UnsupportedOperationException();
	}

	double getHeight() {
		throw new UnsupportedOperationException();
	}

	public void addBase(Base barrier, Coordinate coord) {
		System.out.println("\t\t"+getClass().getName()+":addBase");
	}

	public abstract Base getBase(Coordinate coord);

	public void removeFromTrackPart(Base aBase) {
		throw new UnsupportedOperationException();
	}

	protected boolean containCoord(Coordinate coord) {
		System.out.println("\t\t\t" + getClass().getName()+":containCoord");
		return true;
	}

}