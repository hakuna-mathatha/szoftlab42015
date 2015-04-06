package Phoebe.trackpackage;
import Phoebe.basepackage.*;
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

	public JumpablePart() {}

	public JumpablePart(Coordinate position, double width, double height){

		super(position, width, height);
		bases = new ArrayList<Base>();

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
		for(Base b : bases){

			//ha valamelyik hatókörében van, akkor azt visszaadja
			if(b.isCoordNear(coord))
				return b;
		}

		//ha nem esik semmilyen elem hatósugarába, akkor tiszta elemet ad vissza
		return new Pure();
	}

	public void addBase(Base base, Coordinate coord) {
		
		System.out.println("<<<<??????????????");
		System.out.println("\t\t\t\t"+getClass().getName()+":addBase");
		System.out.println("<<<<??????????????");
//		System.out.println(bases.size());
		
		//betesszük a listába az elemet
		bases.add(base);
		System.out.println(bases.size());

	}

	public void removeFromTrackPart(Base base) {

		System.out.println("\t\t\t" + getClass().getName() + ":removeFromTrackPart");

		//remove true-val tér vissza, ha sikeresen törölt a listából, false-al, ha nem. ha sikertelen a törlés, hiba van
		if (!(bases.remove(base))) {
			//itt az elem nem volt a listában, hibakezelés kell
		}
		System.out.println(bases.size());
	}
}