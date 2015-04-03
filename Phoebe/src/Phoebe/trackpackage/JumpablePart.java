package Phoebe.trackpackage;
import Phoebe.basepackage.*;
import java.util.ArrayList;
import java.util.List;

import Phoebe.basepackage.Base;

public class JumpablePart extends TrackPart {

	List<Base> barriers;

	public JumpablePart(){
		barriers = new ArrayList<Base>();
		barriers.add(new Oil());
		barriers.add(new Putty());
		barriers.add(new Pure());
	}
	
	/**
	 * 
	 * @param coord
	 * @return 
	 */
	public Base getBase(Coordinate coord) {
//		throw new UnsupportedOperationException();
		System.out.println("\t\t"+getClass().getName()+":getBarrier");
		for(Base b : barriers){
			b.isCoordNear(coord);
		}
		return barriers.get(0);
	}

}