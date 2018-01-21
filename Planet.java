import javafx.scene.shape.Circle;

public class Planet extends Circle {
	private double mass;
	private double g = 6.63*Math.pow(10,-11);
	
	public double[] vel = new double[2];
	public double[] acc = new double[2];
	public double[] pos = new double[2];
	
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
	
	public void updatePos() {
		pos[0]+=vel[0]*.005;
		pos[1]+=vel[1]*.005;
	}
	public void updateVel() {
		vel[0]+=acc[0];
		vel[1]+=acc[1];
	}
	public void updateAcc(Planet b) {
		double magA = 1/Math.pow(getDistance(b),2)*b.mass;
		
		//System.out.println(Arrays.toString(this.pos)+"what"+Arrays.toString(b.pos));
		//System.out.println(getDistance(b)+" "+Math.pow(getDistance(b),2)+", "+b.mass+" "+1/Math.pow(getDistance(b),2)*b.mass*10000+" "+magA);
		//double[] posB = b.getPosition();
		//System.out.println(Arrays.toString(this.getPosition()));
		double[] direction = {b.pos[0]-pos[0],b.pos[1]-pos[1]};
		//System.out.println(Arrays.toString(direction));
		direction= new double[] {direction[0]/getDistance(b),direction[1]/getDistance(b)};
		//System.out.println(Arrays.toString(direction));
		//System.out.print(Arrays.toString(direction));
		acc[0] = direction[0]*magA;
		acc[1] = direction[1]*magA;
		//System.out.println(" "+Arrays.toString(vel)+" "+Arrays.toString(acc)+" "+Arrays.toString(pos));
	}
	public double getDistance(Planet m) {
		return Math.sqrt(Math.pow(m.pos[0]-this.pos[0],2)+Math.pow(m.pos[1]-this.pos[1],2));
	}
}
