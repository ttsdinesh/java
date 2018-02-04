import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Dinesh Thangaraj
 *
 *         Created on 21-May-2017
 */
public class BlockingQueueExampleProducerConsumer {
	public static void main(String[] args) {
		BlockingQueue<String> bq = new LinkedBlockingQueue<>(10);
		BlockingQueueExampleProducerConsumer bqExample = new BlockingQueueExampleProducerConsumer();
		Producer p = bqExample.new Producer(bq);
		Consumer c = bqExample.new Consumer(bq);
		new Thread(p).start();
		new Thread(c).start();
	}

	class Producer implements Runnable {
		BlockingQueue<String> bq;

		Producer(BlockingQueue<String> bq) {
			this.bq = bq;
		}

		@Override
		public void run() {
			try {
				for (int i = 0; i < 20; i++) {
					System.out.println("Going to put");
					this.bq.put("" + i);
					// TimeUnit.SECONDS.sleep(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	class Consumer implements Runnable {
		BlockingQueue<String> bq;
		ExecutorService exec = Executors.newFixedThreadPool(2);

		Consumer(BlockingQueue<String> bq) {
			this.bq = bq;
		}

		Runnable runnable = () -> {
			try {
				System.out.println("Going to poll using the thread: " + Thread.currentThread().getName() + ". Result: "
						+ bq.poll());
				TimeUnit.MILLISECONDS.sleep(1000);
			} catch (Exception w) {
				w.printStackTrace();
			}
		};

		@Override
		public void run() {
			while (true)
				try {
					exec.submit(runnable);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}
}
