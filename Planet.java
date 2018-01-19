import javafx.scene.shape.Circle;

public class Planet extends Circle {
	private double mass;
	
	public Planet(double m) {
		this.mass = m;
	}
	public double getMass() {
		return mass;
	}
}
