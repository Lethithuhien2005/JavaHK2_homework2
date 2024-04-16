package Eg_MultiThreading;

public class SumThread extends Thread {
	int n;
	long S=0;

	public SumThread(int k) {
		n=k;
	}
	@Override
	public void run() {
		for (int i=0; i<=n; i++) {
			S+=i;
		}
		System.out.println("F2 = " + S);
	}
	public long getResult() {
		return S;
	}
}
