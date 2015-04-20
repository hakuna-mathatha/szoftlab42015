package Phoebe.trackpackage;

import java.util.ArrayList;
import Phoebe.basepackage.*;
import java.util.List;

import Phoebe.helperpackage.JSONHandler;

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

		//Csinaltam egy alap palyat. negyzet alaku. csak hogy ha akar valaki akkor lehessen tesztet kitalalni
		System.out.println("\t"+getClass().getName()+":create");
		String baseURL = System.getProperty("user.dir")+"/data/";
		System.out.println(baseURL);
		try{
		JumpablePart jumpablePart1 = (JumpablePart) JSONHandler.readStream(baseURL+"jumpablePart1.dat",JumpablePart.class);
		JumpablePart jumpablePart2 = (JumpablePart) JSONHandler.readStream(baseURL+"jumpablePart2.dat",JumpablePart.class);
		JumpablePart jumpablePart3 = (JumpablePart) JSONHandler.readStream(baseURL+"jumpablePart3.dat",JumpablePart.class);
		JumpablePart jumpablePart4 = (JumpablePart) JSONHandler.readStream(baseURL+"jumpablePart4.dat",JumpablePart.class);
		
		trackParts.add(jumpablePart1);
		trackParts.add(jumpablePart2);
		trackParts.add(jumpablePart3);
		trackParts.add(jumpablePart4);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		edge = new EdgeofTheTrack();
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