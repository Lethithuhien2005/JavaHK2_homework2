package Exercise_MutiThreading;

import java.util.concurrent.Semaphore;

public class PhilosopherDinnerProblem {
	private static int NUM_PHILOSOPHERS = 5;
    private static Semaphore[] forks = new Semaphore[NUM_PHILOSOPHERS];
    private static Semaphore waiter = new Semaphore(NUM_PHILOSOPHERS - 1);

    public static void main(String[] args) {
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            forks[i] = new Semaphore(1);
        }

        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            Thread philosopher = new Thread(new Philosopher(i));
            philosopher.start();
        }
    }

    static class Philosopher implements Runnable {
        private final int id;
        private final int leftForkIndex;
        private final int rightForkIndex;

        Philosopher(int id) {
            this.id = id;
            this.leftForkIndex = id;
            this.rightForkIndex = (id + 1) % NUM_PHILOSOPHERS;
        }

        private void think() throws InterruptedException {
            System.out.println("Philosopher " + id + " is thinking...");
            Thread.sleep((long) (Math.random() * 1000));
        }

        private void pickUpLeftFork() throws InterruptedException {
            forks[leftForkIndex].acquire();
            System.out.println("Philosopher " + id + " picks up left fork.");
        }

        private void pickUpRightFork() throws InterruptedException {
            forks[rightForkIndex].acquire();
            System.out.println("Philosopher " + id + " picks up right fork.");
        }

        private void eat() throws InterruptedException {
            pickUpLeftFork();
            pickUpRightFork();

            System.out.println("Philosopher " + id + " is eating...");
            Thread.sleep((long) (Math.random() * 1000));

            forks[leftForkIndex].release();
            forks[rightForkIndex].release();
            System.out.println("Philosopher " + id + " releases forks.");
        }

        private void putDownLeftFork() {
            forks[leftForkIndex].release();
            System.out.println("Philosopher " + id + " puts down left fork.");
        }

        private void putDownRightFork() {
            forks[rightForkIndex].release();
            System.out.println("Philosopher " + id + " puts down right fork.");
        }

        @Override
        public void run() {
            try {
                while (true) {
                    think();
                    waiter.acquire(); // Acquire permission from the waiter
                    eat();
                    waiter.release(); // Release permission for the next philosopher
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
