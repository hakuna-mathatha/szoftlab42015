package Phoebe.trackpackage;
import Phoebe.basepackage.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import Phoebe.basepackage.Base;

public class JumpablePart extends TrackPart {

	private List<Base> bases;

	public List<Base> getBases() {

		return bases;
	}

	public void setBases(List<Base> bases) {

		this.bases = bases;
	}

	public JumpablePart() {

		this.bases = new ArrayList<Base>();
	}

	public JumpablePart(Coordinate position, double width, double height){

		this.position = position;
		this.width = width;
		this.height = height;
		
		this.bases = new ArrayList<Base>();

//		System.out.println("bases list created");
		//bases.add(new Oil());
		//bases.add(new Putty());
		//bases.add(new Pure());
	}

	/**
	 * 
	 * @param coord
	 * @return 
	 */
	public Base getBase(Coordinate coord) {

//		throw new UnsupportedOperationException();
		System.out.println("\t\t"+getClass().getName()+":getBarrier");
		
		//keresés az elemek között
		Timestamp timestamp = new Timestamp(0);
		Base base = new Pure();
		for(Base b : bases){

			//ha valamelyik hatókörében van, akkor azt visszaadja
			if(b.isCoordNear(coord) && b.getTimeStamp().compareTo(timestamp)>0)
			 base =  b;
		}

		//ha nem esik semmilyen elem hatósugarába, akkor tiszta elemet ad vissza
		return base;
	}

	public void addBase(Base base, Coordinate coord) {
		
		System.out.println("\t\t\t\t"+getClass().getName()+":addBase");
		
//		System.out.println(bases.size());
		
		//betesszük a listába az elemet
		base.setTimeStamp(new Timestamp(System.currentTimeMillis()));
		bases.add(base);
//		System.out.println(bases.size());

	}

	public void removeFromTrackPart(Base base) {

		System.out.println("\t\t\t" + getClass().getName() + ":removeFromTrackPart");

		//remove true-val tér vissza, ha sikeresen törölt a listából, false-al, ha nem. ha sikertelen a törlés, hiba van
		if (!(bases.remove(base))) {
			//itt az elem nem volt a listában, hibakezelés kell
		}
//		System.out.println(bases.size());
	}
}