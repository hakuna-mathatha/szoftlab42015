package Phoebe.trackpackage;
import Phoebe.basepackage.*;
import java.sql.Time;
import Phoebe.gamepackage.Bot;

public abstract class Barrier extends Base {
	
	private Time timeStamp;
	private Coordinate position;

	public abstract void modifyDisplacement(Bot bot);

	public abstract void setState(Bot bot);

	public boolean isCoordNear(Coordinate coord) {
		System.out.println("\t\t\t"+getClass().getName()+":containCoord");
		return true;
	}

}