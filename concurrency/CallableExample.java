import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *  *
 *   * @author dinesht
 *    */
public class CallableExample
{
    public static void main( String[] args ) throws Exception
    {
        ExecutorService exec = Executors.newFixedThreadPool( 1 );

        Future<Integer> future = exec.submit( new CallableClass() );
        System.out.println( future.get() );

        if( exec.isTerminated() == false )
        {
            System.out.println( "Shutting down" );
            exec.shutdown();
        }
    }

    static class CallableClass
            implements Callable
    {
        @Override
        public Integer call()
        {
            try
            {
                Thread.sleep( 1000 );
                System.out.println( "Sleeping" );
            }
            catch( Exception e )
            {
                System.out.println( e );
            }
            return 1;
        }
    }
}

