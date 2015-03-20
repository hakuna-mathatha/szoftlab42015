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
		System.out.println("\t"+getClass().getName()+":Track");
		trackParts = new ArrayList<JumpablePart>();
	}
	
	public void create() {
		System.out.println("\t"+getClass().getName()+":create");
		
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
		System.out.println("\t\t"+getClass().getName()+":findAPart");
		
		for(JumpablePart p : trackParts){
			p.containCoord(coord);
		}
		
		return  trackParts.get(0);
	}

}