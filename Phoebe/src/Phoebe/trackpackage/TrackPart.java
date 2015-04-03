package Phoebe.trackpackage;
import Phoebe.basepackage.*;
public abstract class TrackPart {

	private Coordinate position;
	private double width;
	private double height;

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
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
	
	public void setPosition(Coordinate p){
		position = p;
	}
	
	public Coordinate getPosition(){
		return position;
	}

}