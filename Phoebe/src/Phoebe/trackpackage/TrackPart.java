package Phoebe.trackpackage;
import Phoebe.basepackage.*;
public abstract class TrackPart {

	protected Coordinate position;
	protected double width;
	protected double height;

	public double getWidth() {

		return width;
	}

	public double getHeight() {

		return height;
	}

	public void setPosition(Coordinate p){

		position = p;
	}

	public Coordinate getPosition(){

		return position;
	}

	public abstract Base getBase(Coordinate coord);

	public abstract void addBase(Base base, Coordinate coord);

	public abstract void removeFromTrackPart(Base aBase);

	public boolean containCoord(Coordinate coord) {

		System.out.println("\t\t\t" + getClass().getName()+":containCoord");

		//így kevesebb lekérdezésre van szükség
		double tmpX = coord.getX();
		double tmpY = coord.getY();
		double tmpPX = position.getX();
		double tmpPY = position.getY();

		//ha rajta van a az elemen, akkor a paraméter koordinátái az elem szélei között vannak
		if (tmpX >= tmpPX && tmpX <= (tmpPX + width) && tmpY <= tmpPY && tmpY >= (tmpPY - height)) {
			return true;
		}

		//ha valamelyik koordinátája kilóg az elem tartományából, akkor nincs rajta
		return false;
	}
}