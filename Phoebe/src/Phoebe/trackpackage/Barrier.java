package Phoebe.trackpackage;

import java.sql.Time;
import Phoebe.gamepackage.Bot;

public abstract class Barrier {
	
	private Time timeStamp;
	private Coordinate position;

	public abstract void modifyDisplacement(Bot bot);

	public abstract void setState(Bot bot);

	protected boolean containCoord(Coordinate coord) {
		System.out.println("\t\t\t"+getClass().getName()+":containCoord");
		return true;
	}

	Coordinate getPosition() {
		throw new UnsupportedOperationException();
	}

	void setPosition(Coordinate position) {};

}