import java.util.concurrent.CountDownLatch;

public class CountdownLatchExample
{
	public static void main(String[] args)
	{
		CountDownLatch latch = new CountDownLatch(2);

		Thread waiter = new Thread(new LatchWaiter(latch));
		waiter.start();

		Thread decreamenter = new Thread(new LatchDecreamenter(latch));
		decreamenter.start();
	}
}

class LatchWaiter implements Runnable
{
	CountDownLatch latch = null;

	public LatchWaiter(CountDownLatch latch)
	{
		this.latch = latch;
	}

	@Override
	public void run()
	{
		try
		{
			this.latch.await();
		}
		catch (Exception e)
		{
			System.out.println("Exception: " + e);
		}
		System.out.println("Latch released");
	}
}

class LatchDecreamenter implements Runnable
{
	CountDownLatch latch = null;

	public LatchDecreamenter(CountDownLatch latch)
	{
		this.latch = latch;
	}

	@Override
	public void run()
	{
		try
		{
			Thread.sleep(1000);
			this.latch.countDown();

			Thread.sleep(1000);
			this.latch.countDown();

			Thread.sleep(1000);
			this.latch.countDown();
		}
		catch (Exception e)
		{
			System.out.println("Exception: " + e);
		}
	}
}
