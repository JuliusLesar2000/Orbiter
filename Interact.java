package finalProject;



public class Interact {
	private Planet a;
	private Planet b;
	double[][] posA;
	double[][] posB;
	public Interact(Planet m, Planet n) {
		this.a= m;
		this.b= n;
		posA = new double[10000][10000];
		posB = new double[10000][10000];
	}


	public double findDistance(){
		return a.getDistance(b);
	}

	public void crunchValues() {
		for(int x = 0;x<10000;x++) {
			a.updateAcc(b);
			b.updateAcc(a);
			a.updateVel();
			b.updateVel();
			a.updatePos();
			b.updatePos();
			posA[x][x] = a.pos[0];
			posB[x][x] = b.pos[0];
		}
	}
	public double[][] getA(){
		return posA;
	}
	public double[][] getB(){
		return posB;
	}
}

