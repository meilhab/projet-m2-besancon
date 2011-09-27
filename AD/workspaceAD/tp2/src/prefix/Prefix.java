package prefix;

import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Prefix {
	static class Worker extends Thread {
		int []array;
		int ith;
		int length;
		CyclicBarrier barrier;
		
		public Worker(int[] array, int ith, int length, CyclicBarrier barrier) {
			// put your code here
			this.array = array;
			this.ith = ith;
			this.length = length;
			this.barrier = barrier;
		}

		public void run() {
			// put your code here
			try {
				int pref = 0;
				for(int i=ith; i<length; i++){
					pref += array[i];
					array[i] = pref;
				}

				barrier.await();

				int somme = 0;
				for(int i=length-1; i<ith*length; i = i + length){
					somme += array[i];
				}
				
				barrier.await();
				
				for(int i=ith; i<length; i++){
					array[i] += somme;
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}

	}

	static final int N = 20000;
	static final int NTHREADS = 10;

	// N % NTHREADS must be 0

	public static void main(String[] args) {

		// initialization
		final int[] array = new int[N];
		for (int i = 0; i < N; ++i) {
			array[i] = (int) (Math.random() * 10.);
		}
		int[] copy = Arrays.copyOf(array, array.length);

		// work
		Thread threads[] = new Thread[NTHREADS];

		final int length = N / NTHREADS;
		CyclicBarrier barrier = new CyclicBarrier(NTHREADS);

		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Worker(array, i, length, barrier);
		}

		for (Thread thread : threads) {
			thread.start();
		}

		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// check
		int val = 0;
		boolean ok = true;
		for (int i = 0; i < array.length; ++i) {
			val += copy[i];
			if (val != array[i]) {
				System.out.println("Error at row: " + i);
				ok = false;
			}
		}

		if (ok) {
			System.out.println("OK!");
		} else {
			System.out.println("K0!");
		}
	}

}
