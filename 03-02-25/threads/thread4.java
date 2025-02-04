package threads;

public class thread4 extends Thread {
	  @Override
	  public void run() {
	    System.out.println("Hello, World!");
	  }

	  public static void main(String[] args) {
	    thread4 thread = new thread4();
	    thread.start();
	  }

}
