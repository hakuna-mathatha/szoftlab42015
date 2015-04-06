package Phoebe.trackpackage;
import Phoebe.basepackage.*;
import java.sql.Time;
import java.sql.Timestamp;

import Phoebe.gamepackage.Bot;

public abstract class Barrier extends Base {
	
	protected Timestamp timeStamp;

	public abstract void stepOn(Bot bot);

	//ha teljesen feltakar�tott�k, vagy lej�rt az idje, t�rli mag�t a p�ly�r�l
	public void clean() {
		System.out.println("\t\t\t" + getClass().getName() + ":clean");

		trackPart.removeFromTrackPart(this);
	}
}