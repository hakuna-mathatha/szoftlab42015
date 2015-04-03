package Phoebe.trackpackage;

import Phoebe.basepackage.Base;

public class EdgeofTheTrack extends TrackPart {

	Edge edge;
	
	public EdgeofTheTrack(){
		edge =  new Edge();
	}


	@Override
	public Base getBase(Coordinate coord) {
		return edge;
	}

}