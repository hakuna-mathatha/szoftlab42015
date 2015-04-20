package Phoebe.trackpackage;

import Phoebe.basepackage.Base;

public class EdgeofTheTrack extends TrackPart {

	Edge edge;

	public EdgeofTheTrack() {

		edge = new Edge();
	}

	@Override
	public Base getBase(Coordinate coord) {

		//csak ez lehet, hiszen a pálya szélén vagyunk
		return edge;
	}

	public void addBase(Base base, Coordinate coord) {

		//soha nem fog hívódni, ezért nincs törzse
//		System.out.println("\t\t\t\t" + getClass().getName() + ":addBase");

	}

	public void removeFromTrackPart(Base aBase) {

		//soha nem fog hívódni, ezért nincs törzse
//		System.out.println("\t\t\t" + getClass().getName() + ":removeFromTrackPart");
	}

}