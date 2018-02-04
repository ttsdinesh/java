import java.util.concurrent.TimeUnit;

/**
 * @author Dinesh Thangaraj
 *
 *         Created on 04-Apr-2017
 */
public class PingPong {
	public static void main(String[] args) {
		Object sharedObject = new Object();
		Thread ping = new Thread(new Ping(sharedObject));
		Thread pong = new Thread(new Pong(sharedObject));
		ping.start();
		pong.start();
	}
}

class Pong implements Runnable {
	Object sharedObject;

	Pong(Object sharedObject) {
		this.sharedObject = sharedObject;
	}

	@Override
	public void run() {
		while (true) {
			try {
				synchronized (this.sharedObject) {
					TimeUnit.SECONDS.sleep(1);
					System.out.println("Pong");
					this.sharedObject.notifyAll();
					this.sharedObject.wait();
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}

class Ping implements Runnable {
	Object sharedObject;

	Ping(Object sharedObject) {
		this.sharedObject = sharedObject;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (this.sharedObject) {
				try {
					TimeUnit.SECONDS.sleep(2);
					System.out.println("Ping");
					this.sharedObject.notifyAll();
					this.sharedObject.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
