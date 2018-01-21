package finalProject;

public class Interact {
	private Planet a;
	private Planet b;

	public Interact(Planet m, Planet n) {
		this.a= m;
		this.b= n;
	}


	public double findDistance(Planet a, Planet b){
		return a.getDistance(b);
	}
	
	
	
}
