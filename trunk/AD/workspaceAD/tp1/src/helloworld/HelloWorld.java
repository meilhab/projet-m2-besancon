package helloworld;

class HelloWorld {

	static class SayHello extends Thread {

		public void run() {
			System.out.println("Hello World from " + this.getId());
		}

	}

	public static final int NTHREADS = 10;

	public static void main(String[] args) {
		SayHello sh[] = new SayHello[10];
		for(int i=0; i<10; i++){
			sh[i] = new SayHello();
			sh[i].start();
		}
	}
}