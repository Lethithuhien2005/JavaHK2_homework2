package Exercise_MutiThreading;

import java.util.concurrent.ThreadLocalRandom;

public class Ex2 extends Thread {
	int randNumber;
	@Override
	public synchronized void run() {
		randNumber = ThreadLocalRandom.current().nextInt(1,31);
		System.out.println("The random number is " + randNumber);
	}
	public int number() {
		return randNumber;
	}
}
