package Exercise_MutiThreading;

public class MainEx2 {
	int sum = 0;
	public MainEx2() {
		Ex2 t1 = new Ex2();
		Ex2 t2 = new Ex2();
		Ex2 t3 = new Ex2();
		Ex2 t4 = new Ex2();
		Ex2 t5 = new Ex2();
		Ex2 t6 = new Ex2();
		Ex2 t7 = new Ex2();
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
			t6.join();
			t7.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		sum = t1.number() + t2.number() + t3.number() + t4.number() + t5.number() + t6.number() + t7.number();
		System.out.println("Sum of 7 random numbers is " + sum);
	}

	public static void main(String[] args) {
		new MainEx2();
	}
}
