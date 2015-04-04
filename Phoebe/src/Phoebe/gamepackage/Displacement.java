package Phoebe.gamepackage;

public class Displacement {

	// A szog radianban 
	public double angle;
	//Az elmozdulas vektor hossza
	public double velocity;
	
	public Displacement(){
		
	}
	
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