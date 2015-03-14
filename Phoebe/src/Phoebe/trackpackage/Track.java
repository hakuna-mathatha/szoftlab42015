package Phoebe.trackpackage;

public class Track {

	EdgeofTheTrack edge;

	/**
	 * 
	 * @return 
	 */
	
	public Track(){
		System.out.println("	A palya letrehozasa.");
	}
	
	public void create() {
		System.out.println("		A palyaelemek letrehozasa a beolvasott adatok alapjan.");
	}

	/**
	 * 
	 * @param coord
	 * @return 
	 */
	public TrackPart findAPart(Coordinate coord) {
		throw new UnsupportedOperationException();
	}

}