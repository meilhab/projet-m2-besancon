package cigarette;

import java.util.concurrent.Semaphore;

public class Cigarette {
	static class Smoker extends Thread {
		private final int i;
		/* put synchronization objects here */
		Semaphore semSmoker;
		Semaphore semArbitre;

		public Smoker(int i /* add synchronization objects for initialization */
				, Semaphore semSmoker, Semaphore semArbitre) {
			this.i = i;
			/* initialize synchronization objects */
			this.semSmoker = semSmoker;
			this.semArbitre = semArbitre;
		}

		public static final int MAKING_DURATION = 5000;
		public static final int SMOKING_DURATION = 5000;

		public void makeCigarette() throws InterruptedException {
			System.out.println("Smoker " + i + " is making a cigarette");
			Thread.sleep((int) (Math.floor(Math.random() * MAKING_DURATION)));
			System.out.println("Smoker " + i + " has finished making a cigarette");
		}

		public void smokeCigarette() throws InterruptedException {
			System.out.println("Smoker " + i + " is smoking a cigarette");
			Thread.sleep((int) (Math.floor(Math.random() * SMOKING_DURATION)));
			System.out.println("Smoker " + i + " has finished smoking a cigarette");
		}

		@Override
		public void run() {
			/* put your code here */
			try {
				while(true){
					semSmoker.acquire();
					makeCigarette();
					semArbitre.release();
					smokeCigarette();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	static class Arbiter extends Thread {

		/* put synchronization objects here */
		Semaphore []semSmokers;
		Semaphore semArbitre;

		public Arbiter(/* add synchronization objects for initialization */
				Semaphore semSmokers[], Semaphore semArbitre) {
			/* initialize synchronization objects */
			this.semSmokers = semSmokers;
			this.semArbitre = semArbitre;
		}

		public void chooseSmoker(int i) {
			System.out.println("Arbiter choose smoker " + i);
		}

		public static final int CIGARETTES = 15;
		
		@Override
		public void run() {
			/* put your code here */
			try {
				for(int i=0; i<CIGARETTES; i++){
					semArbitre.acquire();
					int smoker = (int) (Math.random() * 3);
					chooseSmoker(smoker);
					semSmokers[smoker].release();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		/* put synchronization objects here */
		Semaphore semSmokers[] = new Semaphore[3];
		Semaphore semArbitre = new Semaphore(1);
		
		Smoker[] smokers = new Smoker[3];
		for (int i = 0; i < smokers.length; ++i) {
			semSmokers[i] = new Semaphore(0);
			smokers[i] = new Smoker(i /* add synchronization objects for initialization */
					, semSmokers[i], semArbitre);
		}
		Arbiter arbiter = new Arbiter(/* add synchronization objects for initialization */
				semSmokers, semArbitre);

		for(Smoker smoker : smokers) {
			smoker.start();
		}
		arbiter.start();

		try {
			arbiter.join();
			Thread.sleep(Smoker.SMOKING_DURATION); // to be sure the last smoker has finished
		} catch (InterruptedException e) {
		}
		for(Smoker smoker : smokers) {
			smoker.interrupt();
		}
		
	}
}
