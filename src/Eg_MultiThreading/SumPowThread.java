package Eg_MultiThreading;

public class SumPowThread extends Thread {
	int x,n;
	long S=0;
	public SumPowThread(int y, int k) {
		x=y;
		n=k;
	}
	@Override
	public void run() {
		for (int i=1; i<=n; i++) {
			S = (long) (S + Math.pow(x, i));
		}
		System.out.println("F3 = " + S);
	}
	public long getResult() {
		return S;
	}
}
