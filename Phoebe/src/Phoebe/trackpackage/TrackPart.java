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
	public void addBarrier(Barrier barrier, Coordinate coord) {
		//throw new UnsupportedOperationException();
		System.out.println("\t\t"+getClass().getName()+":addBarrier");
	}

	/**
	 * 
	 * @param coord
	 * @return 
	 */
	public abstract Barrier getBarrier(Coordinate coord);

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
	protected boolean containCoord(Coordinate coord) {
//		throw new UnsupportedOperationException();
		System.out.println("\t\t\t" + getClass().getName()+":containCoord");
		
		return true;
	}

}