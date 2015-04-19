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
		
		//keres�s az elemek k�z�tt
		Timestamp timestamp = new Timestamp(0);
		Base base = new Pure();
		for(Base b : bases){

			//ha valamelyik hat�k�r�ben van, akkor azt visszaadja
			if(b.isCoordNear(coord) && b.getTimeStamp().compareTo(timestamp)>0)
			 base =  b;
		}

		//ha nem esik semmilyen elem hat�sugar�ba, akkor tiszta elemet ad vissza
		return base;
	}

	public void addBase(Base base, Coordinate coord) {
		
		System.out.println("\t\t\t\t"+getClass().getName()+":addBase");
		
//		System.out.println(bases.size());
		
		//betessz�k a list�ba az elemet
		base.setTimeStamp(new Timestamp(System.currentTimeMillis()));
		bases.add(base);
//		System.out.println(bases.size());

	}

	public void removeFromTrackPart(Base base) {

		System.out.println("\t\t\t" + getClass().getName() + ":removeFromTrackPart");

		//remove true-val t�r vissza, ha sikeresen t�r�lt a list�b�l, false-al, ha nem. ha sikertelen a t�rl�s, hiba van
		if (!(bases.remove(base))) {
			//itt az elem nem volt a list�ban, hibakezel�s kell
		}
//		System.out.println(bases.size());
	}
}