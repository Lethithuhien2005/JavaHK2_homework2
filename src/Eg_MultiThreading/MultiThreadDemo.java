package Eg_MultiThreading;

public class MultiThreadDemo {
	FacThread t1 = new FacThread(5);
	SumThread t2 = new SumThread(100);
	SumPowThread t3 = new SumPowThread(2, 5);
	public MultiThreadDemo() {
		t1.start();
		t2.start();
		t3.start();
		try {
			t1.join();
			t2.join();
			t3.join();
			long S = t1.getResult() + t2.getResult() + t3.getResult();
			System.out.println("Ket qua = " + S);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new MultiThreadDemo();
	}
}
