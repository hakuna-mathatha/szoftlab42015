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

		//�gy kevesebb lek�rdez�sre van sz�ks�g
		double tmpX = coord.getX();
		double tmpY = coord.getY();
		double tmpPX = position.getX()+ray/2;
		double tmpPY = position.getY()+ray/2;

		//ha a koordin�t�k t�vols�ga p�ronk�nt kisebb, mint a hat�sug�r, akkor a hat�ter�let�n van (n�gzet alak�), a hat�rok is sz�m�tanak
		if (Math.abs(tmpX - tmpPX) <= ray && Math.abs(tmpY - tmpPY) <= ray) {
//		if ((tmpX >= tmpPX && tmpX < (tmpPX + ray)) && (tmpY >= tmpPY && tmpY < (tmpPY + ray))) {
			return true;
		}

		//ha messzebb vannak egym�st�l, akkor nincs k�lcs�nhat�s
		return false;
	}

	public BaseType getType() {

//		System.out.println("\t\t" + getClass().getName() + ":getType()");
		return type;
	}
		
}
