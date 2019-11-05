package util.java.thread;

// https://docs.oracle.com/javase/tutorial/essential/concurrency/runthread.html

public class HelloThread extends Thread {

	public void run() {
		System.out.println("Hello from a thread!");
	}

	public static void main(String args[]) {
		(new HelloThread()).start();
	}

}