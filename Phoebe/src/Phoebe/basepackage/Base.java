package Phoebe.basepackage;
import Phoebe.gamepackage.*;
import Phoebe.trackpackage.*;

public abstract class Base {
	protected Coordinate position;
	protected BaseType type;
	protected JumpablePart trackPart;
	protected JumpablePart bases;
	
	public Base() {
		
	}

	public Coordinate getPosition() {
		throw new UnsupportedOperationException();
	}

	public void setPosition(Coordinate aPosition) {
		throw new UnsupportedOperationException();
	}

	public abstract void stepOn(Bot aBot);

	public boolean isCoordNear(Coordinate aCoord) {
		throw new UnsupportedOperationException();
	}

	public void getType() {
		System.out.println("Base tipus, majd felul kell irni a leszarmazottakban");
	}
		
}
