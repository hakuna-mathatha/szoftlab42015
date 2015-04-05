package Phoebe.trackpackage;

import java.util.ArrayList;
import java.util.List;

public class Track {

	private EdgeofTheTrack edge;
	private List<JumpablePart> trackParts;

	public List<JumpablePart> getTrackParts() {

		return trackParts;
	}

	public void setTrackParts(List<JumpablePart> trackParts) {

		this.trackParts = trackParts;
	}

	public Track(){

		System.out.println("\t"+getClass().getName()+":Track");
		edge = new EdgeofTheTrack();
		trackParts = new ArrayList<JumpablePart>();
	}
	
	public void create() {

		System.out.println("\t" + getClass().getName() + ":create");

		///??????????

		//trackParts.add(new JumpablePart());
		//edge = new EdgeofTheTrack();
		
	}

	public TrackPart findAPart(Coordinate coord) {

		System.out.println("\t\t"+getClass().getName()+":findAPart");

		//keresés az elemek között
		for(JumpablePart p : trackParts){

			//ha valamelyiken rajta van, akkor azt visszaadja
			if(p.containCoord(coord))
				return p;
		}

		//ha egyiken sem volt rajta, akkor letért a pályáról
		return edge;

		//return  trackParts.get(0);
	}

}