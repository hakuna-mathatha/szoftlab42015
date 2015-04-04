package Phoebe.trackpackage;

public class Coordinate {

	private double x;
	private double y;
	
	public Coordinate() {
		// TODO Auto-generated constructor stub
	}
	
	public Coordinate(double x1, double y1){
		x=x1;
		y=y1;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public Coordinate addCoord(Coordinate a){
		Coordinate coord = new Coordinate();
		coord.x = this.x+a.x;
		coord.y = this.y+a.y;
		return coord;
	}
	
	public Coordinate difCoord(Coordinate a){
		Coordinate coord = new Coordinate();
		coord.x = this.x-a.x;
		coord.y = this.y-a.y;
		return coord;
	}
}