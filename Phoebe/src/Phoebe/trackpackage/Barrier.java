package Phoebe.trackpackage;

import Phoebe.basepackage.*;

import java.sql.Time;
import java.sql.Timestamp;

import Phoebe.gamepackage.Bot;

public abstract class Barrier extends Base {

	

	public abstract void stepOn(Bot bot);

	// ha teljesen feltakarították, vagy lejárt az idje, törli magát a pályáról
	// Legyen szalbiztos mert idozitovel van az olaj torlese neghogy oszeakadjanak
	public synchronized void clean() {
		System.out.println("\t\t\t" + getClass().getName() + ":clean");

				trackPart.removeFromTrackPart(this);

	}
}