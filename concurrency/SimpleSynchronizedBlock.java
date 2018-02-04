import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Dinesh Thangaraj
 *
 *         Created on 01-Aug-2016
 */
public class SimpleSynchronizedBlock {
	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
	}

	void print() {
		synchronized (this) {
			System.out.println("HELLO");
		}
	}

	void locking(Lock lock) {
		lock.lock();
		System.out.println("Hello LOCK");
		lock.unlock();
	}
}
