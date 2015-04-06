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

	public void setPosition(Coordinate p){

		position = p;
	}

	public Coordinate getPosition(){

		return position;
	}

	public TrackPart() {}

	public TrackPart(Coordinate position, double width, double height) {

		this.position = position;
		this.width = width;
		this.height = height;
	}

	public abstract Base getBase(Coordinate coord);

	public abstract void addBase(Base base, Coordinate coord);

	public abstract void removeFromTrackPart(Base aBase);

	public boolean containCoord(Coordinate coord) {

		System.out.println("\t\t\t" + getClass().getName()+":containCoord");

		//�gy kevesebb lek�rdez�sre van sz�ks�g
		double tmpX = coord.getX();
		double tmpY = coord.getY();
		double tmpPX = position.getX();
		double tmpPY = position.getY();

		//ha rajta van a az elemen, akkor a param�ter koordin�t�i az elem sz�lei k�z�tt vannak
		if (tmpX >= tmpPX && tmpX <= (tmpPX + width) && tmpY <= tmpPY && tmpY >= (tmpPY - height)) {
			return true;
		}

		//ha valamelyik koordin�t�ja kil�g az elem tartom�ny�b�l, akkor nincs rajta
		return false;
	}
}