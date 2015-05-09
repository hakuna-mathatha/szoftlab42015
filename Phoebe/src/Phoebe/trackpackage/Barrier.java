package Phoebe.trackpackage;
import Phoebe.basepackage.Base;
import Phoebe.gamepackage.Bot;

public abstract class Barrier extends Base {

	public abstract void stepOn(Bot bot);

	public synchronized void clean() {
		trackPart.removeFromTrackPart(this);
		System.out.println("REMOVE");
		detachObserver();   //Observer levalasztasa
	}
}