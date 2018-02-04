import java.util.ArrayList;
import java.util.List;

public class OneProducerTwoConsumer {
	public static void main(String[] args) {
		List<Integer> pipe = new ArrayList<Integer>();
		Runnable producer = () -> {
			try {
				int count = 0;
				while (true) {
					produce(pipe, count++, 10);
					Thread.sleep(300);
				}
			} catch (InterruptedException e) {
				System.out.println("Exception occured with the producer." + e);
			}
		};

		Runnable consumer = () -> {
			try {
				while (true) {
					consumer(pipe);
					Thread.sleep(400);
				}
			} catch (InterruptedException e) {
				System.out.println("Exception occured with the consumer." + e);
			}
		};

		Thread producerThread = new Thread(producer);
		Thread consumerThread1 = new Thread(consumer, "Consumer1");
		Thread consumerThread2 = new Thread(consumer, "Consumer2");
		producerThread.start();
		consumerThread1.start();
		consumerThread2.start();
	}

	static void produce(List<Integer> pipe, int item, int maxPipeSize) throws InterruptedException {
		synchronized (pipe) {
			if (pipe.size() > 10)
				pipe.wait();
			pipe.add(item);
			pipe.notifyAll();
			System.out.println("Producer produced the item: " + item);
		}
	}

	static void consumer(List<Integer> pipe) throws InterruptedException {
		synchronized (pipe) {
			while (pipe.isEmpty()) {
				System.out.println("Pipe is empty. Waiting for producer to produce.");
				pipe.wait();
			}
			System.out.println(Thread.currentThread().getName() + " consumed the item " + pipe.remove(0));
			pipe.notifyAll();
		}
	}
}
