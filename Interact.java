

public class Interact {
	private Planet a;
	private Planet b;
	double[][] posA;
	double[][] posB;
	double[] curA = new double[3];
	double[] curB = new double[3];
	public Interact(Planet m, Planet n) {
		this.a= m;
		this.b= n;
		posA = new double[1000000][2];
		posB = new double[1000000][2];
		for(double[] d :posA) {
			d = new double[] {-10,-10};
		}
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
			posA[x][0] = a.pos[0];
			posA[x][1] = a.pos[1];
			posB[x][0] = b.pos[0];
			posB[x][1] = b.pos[1];
		}
		curA = new double[] {posA[0][0],posA[0][1],0};
		curB = new double[] {posB[0][0],posB[0][1],0};
	}
	public double[] getA(){
		double[] cur = curA;
		curA = new double[] {posA[(int) (curA[2]+1)][0],posA[(int) (curA[2]+1)][1],curA[2]+1};
		return cur;
	}
	public double[] getB(){
		double[] cur = curB;
		curB = new double[] {posB[(int) (curB[2]+1)][0],posB[(int) (curB[2]+1)][1],curB[2]+1};
		return cur;
	}
}
