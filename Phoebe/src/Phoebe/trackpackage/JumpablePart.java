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

		//keres�s az elemek k�z�tt
		for(Base b : bases){

			//ha valamelyik hat�k�r�ben van, akkor azt visszaadja
			if(b.isCoordNear(coord))
				return b;
		}

		//ha nem esik semmilyen elem hat�sugar�ba, akkor tiszta elemet ad vissza
		return new Pure();
	}

	public void addBase(Base base, Coordinate coord) {

		System.out.println("\t\t\t\t"+getClass().getName()+":addBase");

		//betessz�k a list�ba az elemet
		bases.add(base);

	}

	public void removeFromTrackPart(Base base) {

		System.out.println("\t\t\t" + getClass().getName() + ":removeFromTrackPart");

		//remove true-val t�r vissza, ha sikeresen t�r�lt a list�b�l, false-al, ha nem. ha sikertelen a t�rl�s, hiba van
		if (!(bases.remove(base))) {
			//itt az elem nem volt a list�ban, hibakezel�s kell
		}
	}
}