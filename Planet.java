import javafx.scene.shape.Circle;

public class Planet extends Circle {
	private double mass;
	
	public double[] vel;
	public double[] acc;
	public double[] pos;
	
	public Planet(double m) {
		this.mass = m;
	}
	
	public double getMass() {
		return mass;
	}
	
	public double[] getVelocity() {
		return vel;
	}
	
	public void setVelocity(double[] v) {
		vel = v;
	}
	
	public double[] getAccel() {
		return acc;
	}
	
	public void setAccel(double[] accel) {
		acc = accel;
	}
	
	public double[] getPosition() {
		return pos;
	}
	
	public void setPosition(double[] p) {
		pos = p;
	}
	
	public void updatePos(double cycle) {
		pos[0]+=vel[0]*cycle;
		pos[1]+=vel[1]*cycle;
	}
	
	public double getDistance(Planet m) {
		return Math.sqrt(Math.pow(m.pos[0]-this.pos[0],2)+Math.pow(m.pos[1]-this.pos[1],2));
	}
}
