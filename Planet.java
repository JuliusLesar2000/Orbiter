import javafx.scene.shape.Circle;

public class Planet extends Circle {
	private double mass;
	
	public double[] velocity;
	public double[] acceleration;
	public double[] position;
	
	public Planet(double m) {
		this.mass = m;
	}
	
	public double getMass() {
		return mass;
	}
	
	public double[] getVelocity() {
		return velocity;
	}
	
	public void setVelocity(double[] v) {
		velocity = v;
	}
	
	public double[] getAccel() {
		return acceleration;
	}
	
	public void setAccel(double[] accel) {
		acceleration = accel;
	}
	
	public double[] getPosition() {
		return position;
	}
	
	public void setPosition(double[] pos) {
		position = pos;
	}
	
	public double getDistance(Planet m) {
		return Math.sqrt(Math.pow(m.position[0]-this.position[0],2)+Math.pow(m.position[1]-this.position[1],2));
	}
}
