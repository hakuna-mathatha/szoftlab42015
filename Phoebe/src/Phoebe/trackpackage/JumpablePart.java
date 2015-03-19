package Phoebe.trackpackage;

import java.util.ArrayList;
import java.util.List;

public class JumpablePart extends TrackPart {

	List<Barrier> barriers;

	public JumpablePart(){
		barriers = new ArrayList<Barrier>();
		barriers.add(new Oil());
		barriers.add(new Putty());
		barriers.add(new Pure());
		
//		System.out.println("                     Uj jumpable part");
	}
	
	/**
	 * 
	 * @param coord
	 * @return 
	 */
	public Barrier getBarrier(Coordinate coord) {
//		throw new UnsupportedOperationException();
		System.out.println("			"+getClass().getName()+":getBarrier");
		for(Barrier b : barriers){
			b.containCoord(coord);
		}
		return barriers.get(0);
	}

}