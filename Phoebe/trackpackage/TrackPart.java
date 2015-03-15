package Phoebe.trackpackage;

public abstract class TrackPart {

	private Coordinate position;
	private double width;
	private double height;

	/**
	 * 
	 * @return 
	 */
	double getWidth() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @return 
	 */
	double getHeight() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param barrier
	 * @param coord
	 * @return 
	 */
	void addBarrier(Barrier barrier, Coordinate coord) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param coord
	 * @return 
	 */
	abstract Barrier getBarrier(Coordinate coord);

	/**
	 * 
	 * @param Barrier
	 * @return 
	 */
	public void deletBarrier(int Barrier) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param coord
	 * @return 
	 */
	boolean containCoord(Coordinate coord) {
		throw new UnsupportedOperationException();
	}

}