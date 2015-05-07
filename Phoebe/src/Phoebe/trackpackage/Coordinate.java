package Phoebe.trackpackage;

public class Coordinate {

	public double x;
	public double y;
	
	public Coordinate() {}
	
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
	
	public void dirNormal(Coordinate a, Coordinate b){
		Coordinate c = b.difCoord(a);
		double lenght = c.legth();
		this.x = c.x/lenght;
		this.y = c.y/lenght;
	}
	
	public void normal(Coordinate a){
		double lenght = Math.sqrt(Math.pow(a.x, 2)+Math.pow(a.y, 2));
		this.x = a.x/lenght;
		this.y = a.y/lenght;
	}
	
	public void multip(double d){
		this.x = x*d;
		this.y = y*d;
	}
	
	public double legth(){
		double lenght = Math.sqrt(Math.pow(this.x, 2)+Math.pow(this.y, 2));
		return lenght;
	}
}