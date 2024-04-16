package Eg_MultiThreading;

public class FacThread extends Thread {
	long gt = 1;
	int n;	
	public FacThread(int k) {
		n = k;
	}
	@Override
	public void run() {
		for (int i=1; i<=n; i++) {
			gt = gt*i;
		}
		System.out.println("F1 = " + gt);
	}
	public long getResult() {
		return gt;
	}
	
}
