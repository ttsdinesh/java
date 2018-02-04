import java.util.concurrent.TimeUnit;

/**
 * @author Dinesh Thangaraj
 *
 *         Created on 26-Sep-2016
 */
public class ThreadExecutionOrderusingJoin {
	public static void main(String[] args) {
		ThreadImpl t1 = new ThreadImpl("t1");
		ThreadImpl t2 = new ThreadImpl("t2");
		ThreadImpl t3 = new ThreadImpl("t3");
		try {
			t1.start();
			t1.join();

			t2.start();
			t2.join();

			t3.start();
			t3.join();
		} catch (Exception w) {
			System.out.println("E: " + w);
		}
	}

	static class ThreadImpl extends Thread {
		final String threadName;

		ThreadImpl(String threadName) {
			this.threadName = threadName;
		}

		@Override
		public void run() {
			System.out.println("Executing the thread " + this.threadName);
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (Exception w) {

			}
		}
	}
}
