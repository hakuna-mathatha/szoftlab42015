package Phoebe.gamepackage;

public class Displacement {
	public double angle;   // A szog radianban
	public double velocity;	//Az elmozdulas vektor hossza
	
	public Displacement(){}
	
	public Displacement(double ang, double velo){
		angle = ang;
		velocity =  velo;
	}
	
	public double getAngle() {
		return angle;
	}
	public void setAngle(double angle) {
		this.angle = angle;
	}
	public double getVelocity() {
		return velocity;
	}
	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}
}