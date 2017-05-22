
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author dinesht
 */
public class ThreadPoolExecutorExample
{

    public static void main( String[] args )
    {
//        ExecutorService exec = Executors.newFixedThreadPool( 2 );
//        ExecutorService exec = Executors.newCachedThreadPool();
        ExecutorService exec = Executors.newSingleThreadExecutor();

        for( int i = 0; i < 10; i++ )
        {
            exec.submit( new ThreadClass( "ThreadNo:" + i ) );
        }
        exec.shutdown();//Program will not terminate unless the executor is shutdown
    }

    static class ThreadClass
            extends Thread
    {
        public ThreadClass( String threadName )
        {
            this.currentThread().setName( threadName ); // Thread pool sets the thread name and this line makes no sense
        }

        @Override
        public void run()
        {
            System.out.println( "Executing the thread: " + this.currentThread().getName() );
            try
            {
                Thread.sleep( 1000 );
            }
            catch( Exception e )
            {
                System.out.println( "Exception: " + e );
            }
        }

    }
}
