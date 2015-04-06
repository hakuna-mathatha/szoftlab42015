package Phoebe.trackpackage;
import Phoebe.basepackage.*;
import java.sql.Time;
import java.sql.Timestamp;

import Phoebe.gamepackage.Bot;

public abstract class Barrier extends Base {
	
	private Timestamp timeStamp;

	public Barrier() {}

	public Barrier(Coordinate position, BaseType type, TrackPart trackPart, double ray) {

		super(position, type, trackPart, ray);
		timeStamp = new Timestamp(System.currentTimeMillis());
	}

	public abstract void stepOn(Bot bot);

	//ha teljesen feltakar�tott�k, vagy lej�rt az idje, t�rli mag�t a p�ly�r�l
	public void clean() {
		trackPart.removeFromTrackPart(this);
	}
}