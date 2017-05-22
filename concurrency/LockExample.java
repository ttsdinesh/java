
import java.util.concurrent.locks.*;

/**
 *  *
 *   * @author dinesht
 *    */
public class LockExample
{
    public static void main( String[] args )
    {
        Lock lock = new ReentrantLock();
        LockClass t1 = new LockClass( lock );
        LockClass t2 = new LockClass( lock );

        t1.start();
        t2.start();

    }

    static class LockClass
            extends Thread
    {
        ReentrantLock lock;

        public LockClass( Lock lock )
        {
            this.lock = (ReentrantLock) lock;
        }

        @Override
        public void run()
        {
            try
            {
                lock.lock(); // Use trylock to give a time until which the lock will be there
                for( int i = 0; i < 10; i++ )
                {
                    System.out.println( i );
                    Thread.sleep( 500 );
                }
            }
            catch( Exception e )
            {
                System.out.println( "Exception" + e );
            }
            finally
            {
                lock.unlock(); // Without unlock, the second thread has to wait indefinitely
            }
        }
    }
}

