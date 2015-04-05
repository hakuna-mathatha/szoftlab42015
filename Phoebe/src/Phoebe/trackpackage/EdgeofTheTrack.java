package Phoebe.trackpackage;

import Phoebe.basepackage.Base;

public class EdgeofTheTrack extends TrackPart {

	Edge edge;

	public EdgeofTheTrack() {

		edge = new Edge();
	}


	@Override
	public Base getBase(Coordinate coord) {

		return edge;
	}

	public void addBase(Base base, Coordinate coord) {

		System.out.println("\t\t\t\t" + getClass().getName() + ":addBase");

	}
}