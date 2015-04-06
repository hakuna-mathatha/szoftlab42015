package Phoebe.trackpackage;

import Phoebe.basepackage.Base;

public class EdgeofTheTrack extends TrackPart {

	Edge edge;

	public EdgeofTheTrack() {

		edge = new Edge();
	}

	@Override
	public Base getBase(Coordinate coord) {

		//csak ez lehet, hiszen a p�lya sz�l�n vagyunk
		return edge;
	}

	public void addBase(Base base, Coordinate coord) {

		//soha nem fog h�v�dni, ez�rt nincs t�rzse
		System.out.println("\t\t\t\t" + getClass().getName() + ":addBase");

	}

	public void removeFromTrackPart(Base aBase) {

		//soha nem fog h�v�dni, ez�rt nincs t�rzse
		System.out.println("\t\t\t" + getClass().getName() + ":removeFromTrackPart");
	}

}