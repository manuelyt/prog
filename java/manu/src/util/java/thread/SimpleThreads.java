package util.java.thread;

// https://docs.oracle.com/javase/tutorial/essential/concurrency/runthread.html

import java.util.Date;

public class SimpleThreads {

	// Display a message, preceded by
	// the name of the current thread
	@SuppressWarnings("deprecation")
	static void threadMessage(String message) {
		String threadName = Thread.currentThread().getName();
		Date dat = new Date();
		System.out.format("%s: %s %s %s %n", threadName, message, dat.getSeconds(), dat.getTime());
	}

	private static class MessageLoop implements Runnable {
		public void run() {
			String importantInfo[] = { "Mares eat oats        ", "Does eat oats         ", "Little lambs eat ivy  ",
					"A kid will eat ivy too" };
			try {
				for (int i = 0; i < importantInfo.length; i++) {
					// Pause for 4 seconds
					Thread.sleep(4521);
					// Print a message
					threadMessage(importantInfo[i]);
				}
			} catch (InterruptedException e) {
				threadMessage("I wasn't done!");
			}
		}
	}

	public static void main(String args[]) throws InterruptedException {

		// Delay, in milliseconds before
		// we interrupt MessageLoop
		// thread (default one hour).
		long patience = 1000 * 60 * 60;

		// If command line argument
		// present, gives patience
		// in seconds.
		if (args.length > 0) {
			try {
				patience = Long.parseLong(args[0]) * 1000;
			} catch (NumberFormatException e) {
				System.err.println("Argument must be an integer.");
				System.exit(1);
			}
		}

		threadMessage("Starting MessageLoop thread");
		long startTime = System.currentTimeMillis();
		Thread t = new Thread(new MessageLoop());
		t.start();

		threadMessage("Waiting for MessageLoop thread to finish");
		// loop until MessageLoop
		// thread exits
		int cont = 0;
		int reset = 0;
//		while (t.isAlive()) {
		String sp = " ";
		while (cont < 27) {
			cont++;
			if (cont > 9)
				sp = "";
			threadMessage("Still waiting...        " + sp + cont);
			// Wait maximum of 1 second
			// for MessageLoop thread
			// to finish.
			t.join(1000);
			if (((System.currentTimeMillis() - startTime) > patience) && t.isAlive()) {
				threadMessage("Tired of waiting!");
				t.interrupt();
				// Shouldn't be long now
				// -- wait indefinitely
				t.join();
			}
			if (cont == 22) {
				threadMessage("Tired of waiting!");
				t.interrupt();
				t.join();
			}
			if (!t.isAlive()) {
				t = new Thread(new MessageLoop());
				t.start();
				threadMessage("reset-" + reset);
				reset++;
//				t.run();
//				t.start();  // java.lang.IllegalThreadStateException
			}
		}
		threadMessage("Finally!");
	}
}