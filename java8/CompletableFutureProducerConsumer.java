import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Dinesh Thangaraj
 *
 *         Created on 21-May-2017
 */
public class CompletableFutureProducerConsumer {
	public static final int SIZE = 5;

	public static void main(String[] args) {

		CompletableFutureProducerConsumer obj = new CompletableFutureProducerConsumer();
		final ExecutorService exec = Executors.newFixedThreadPool(2);
		BlockingQueue<String> routingJobQueue = new LinkedBlockingQueue<String>(SIZE);

		// exec.submit(obj.new Producer(routingJobQueue));
		exec.submit(new RoutingConsumer(routingJobQueue));

		exec.shutdown();
	}

	class Producer implements Runnable {
		BlockingQueue<String> routingJobQueue;

		Producer(BlockingQueue<String> routingJobQueue) {
			this.routingJobQueue = routingJobQueue;
		}

		@Override
		public void run() {
			while (true) {
				System.out.println("Adding to queue");
				this.routingJobQueue.add("" + System.nanoTime());
				try {
					TimeUnit.MILLISECONDS.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}

class RoutingConsumer implements Runnable {
	BlockingQueue<String> routingJobQueue;
	final ExecutorService exec;
	ForkJoinPool pool = new ForkJoinPool(3);

	RoutingConsumer(BlockingQueue<String> routingJobQueue) {
		this.routingJobQueue = routingJobQueue;
		exec = Executors.newFixedThreadPool(CompletableFutureProducerConsumer.SIZE);
	}

	@Override
	public void run() {
		// while (true) {
		try {
			HelperClass obj = new HelperClass();
			CompletableFuture.supplyAsync(() -> obj.routeDocument(), exec)
					.thenAcceptAsync(obj::updateRoutingStatus, exec).thenRun(() -> {
						System.out.println("Task completed. Shutting down");
						exec.shutdownNow();
					});
		} catch (Throwable e) {
			e.printStackTrace();
		}
		// }
	}
}

class HelperClass {
	public String routeDocument() throws RuntimeException {
		System.out.println("Route: " + Thread.currentThread().getName());
		System.out.println("Obj: " + this.hashCode());
		try {
			TimeUnit.MILLISECONDS.sleep(1000);
			// throw new RuntimeException("Exception in routing");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "" + System.currentTimeMillis();
	}

	public void updateRoutingStatus(String status) throws RuntimeException {
		System.out.println("Status: " + status + " " + Thread.currentThread().getName());
		System.out.println("Obj: " + this.hashCode());
		try {
			// TimeUnit.MILLISECONDS.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// if (Long.parseLong(status) % 2 == 0)
		// throw new RuntimeException("Exception thrown: " + status);
	}

	public static void handleException(Throwable throwable) throws RuntimeException {
		System.out.println("");
	}
}
