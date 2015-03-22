package Phoebe.trackpackage;

public abstract class TrackPart {

	private Coordinate position;
	private double width;
	private double height;

	double getWidth() {
		throw new UnsupportedOperationException();
	}

	double getHeight() {
		throw new UnsupportedOperationException();
	}

	public void addBarrier(Barrier barrier, Coordinate coord) {
		System.out.println("\t\t"+getClass().getName()+":addBarrier");
	}

	public abstract Barrier getBarrier(Coordinate coord);

	public void deletBarrier(int Barrier) {};

	protected boolean containCoord(Coordinate coord) {
		System.out.println("\t\t\t" + getClass().getName()+":containCoord");
		return true;
	}

}