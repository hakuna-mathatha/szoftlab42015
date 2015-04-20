package Phoebe.trackpackage;
import Phoebe.basepackage.Base;

import java.util.ArrayList;

public abstract class TrackPart {

	protected Coordinate position;
	protected double width;
	protected double height;
    private ArrayList<Barrier> barriersList = new ArrayList<Barrier>();

    public void setBarriersList(Barrier barrier) {
        this.barriersList.add(barrier);
    }

    public ArrayList<Barrier> getBarriersList() {
        return barriersList;
    }

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

//		System.out.println("\t\t\t" + getClass().getName()+":containCoord");

		//�gy kevesebb lek�rdez�sre van sz�ks�g
		double tmpX = coord.getX();
		double tmpY = coord.getY();
		double tmpPX = position.getX();
		double tmpPY = position.getY();

		//ha rajta van a az elemen, akkor a param�ter koordin�t�i az elem sz�lei k�z�tt vannak
		//Itt a szelek gondot okozhatnak. Igaz kicsi a valoszinusege annak hogy pontosan ket elem hatarara erkezzen a robot.
		if (tmpX >= tmpPX && tmpX < (tmpPX + width) && tmpY <= tmpPY && tmpY >= (tmpPY - height)) {
			return true;
		}

		//ha valamelyik koordin�t�ja kil�g az elem tartom�ny�b�l, akkor nincs rajta
		return false;
	}
}