package Phoebe.trackpackage;

import java.sql.Time;

import Phoebe.*;
import Phoebe.gamepackage.Bot;

public abstract class Barrier {

	JumpablePart barriers;
	private Time timeStamp;
	private Coordinate position;

	/**
	 * 
	 * @param bot
	 * @return 
	 */
	public abstract void modifyDisplacement(Bot bot);

	/**
	 * 
	 * @param bot
	 * @return 
	 */
	public abstract void setState(Bot bot);

	/**
	 * 
	 * @param coord
	 * @return 
	 */
	boolean containCoord(Coordinate coord) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @return 
	 */
	Coordinate getPosition() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param position
	 * @return 
	 */
	void setPosition(Coordinate position) {
		throw new UnsupportedOperationException();
	}

}