package Phoebe.trackpackage;

import java.util.ArrayList;
import Phoebe.basepackage.*;
import java.util.List;

import Phoebe.helperpackage.JSONHandler;

public class Track {

	EdgeofTheTrack edge;
	List<JumpablePart> trackParts;

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
		
		//Csinaltam egy alap palyat. negyzet alaku. csak hogy ha akar valaki akkor lehessen tesztet kitalalni
		System.out.println("\t"+getClass().getName()+":create");
		String baseURL = System.getProperty("user.dir")+"/data/";
		
		JumpablePart jumpablePart1 = (JumpablePart) JSONHandler.readStream(baseURL+"jumpablePart1.dat",JumpablePart.class);
		JumpablePart jumpablePart2 = (JumpablePart) JSONHandler.readStream(baseURL+"jumpablePart2.dat",JumpablePart.class);
		JumpablePart jumpablePart3 = (JumpablePart) JSONHandler.readStream(baseURL+"jumpablePart3.dat",JumpablePart.class);
		JumpablePart jumpablePart4 = (JumpablePart) JSONHandler.readStream(baseURL+"jumpablePart4.dat",JumpablePart.class);
		
		trackParts.add(jumpablePart1);
		trackParts.add(jumpablePart2);
		trackParts.add(jumpablePart3);
		trackParts.add(jumpablePart4);
		
		edge = new EdgeofTheTrack();
		
	}

	public TrackPart findAPart(Coordinate coord) {
		System.out.println("\t\t"+getClass().getName()+":findAPart");
		
		for(JumpablePart p : trackParts){
			p.containCoord(coord);
		}
		
		return  trackParts.get(0);
	}

}