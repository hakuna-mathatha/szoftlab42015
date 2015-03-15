package Phoebe.trackpackage;

import java.util.ArrayList;
import java.util.List;

import Phoebe.gamepackage.Robot;

public class Track {

	EdgeofTheTrack edge;
	List<JumpablePart> trackParts;

	/**
	 * 
	 * @return 
	 */
	
	public Track(){
		System.out.println("	A palya letrehozasa.");
		trackParts = new ArrayList<JumpablePart>();
	}
	
	public void create() {
		System.out.println("		A palyaelemek letrehozasa a beolvasott adatok alapjan.");
		
		trackParts.add(new JumpablePart());
		edge = new EdgeofTheTrack();
		
	}

	/**
	 * 
	 * @param coord
	 * @return 
	 */
	public TrackPart findAPart(Coordinate coord) {
//		throw new UnsupportedOperationException();
		System.out.println("Track/findAPart() keresi az elemet");
		
		return  new JumpablePart();
	}

}