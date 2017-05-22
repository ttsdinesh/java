import java.util.*;

/**
 *
 * @author dinesht
 */
public class LambdaProducerConsumer
{

    public static void main( String[] args )
    {
        List<Integer> pipe = new ArrayList<>();

        Runnable producer = ()
                -> 
                {
                    try
                    {
                        int i = 0;
                        while( true )
                        {
                            produce( pipe, i );
                            i++;
                        }
                    }
                    catch( Exception e )
                    {
                        System.out.println( e );
                    }
        };

        Thread producerThread = new Thread( producer );
        producerThread.start();

        Runnable consumer = ()
                -> 
                {
                    try
                    {
                        while( true )
                        {
                            consume( pipe );
                            Thread.sleep( 500 );
                        }
                    }
                    catch( Exception e )
                    {
                        System.out.println( e );
                    }
        };

        Thread consumerThread = new Thread( consumer );
        consumerThread.start();
    }

    static void produce( List<Integer> pipe, int i ) throws InterruptedException
    {
        synchronized( pipe )
        {
            if( pipe.size() == 10 )
            {
                pipe.notifyAll();
                pipe.wait();
            }
            pipe.add( i );
            Thread.sleep( 100 );
            System.out.println( "Produced: " + i );
        }
    }

    static void consume( List<Integer> pipe ) throws InterruptedException
    {
        synchronized( pipe )
        {
            while( pipe.isEmpty() )
            {
                pipe.wait();
            }

            System.out.println( "Consumed: " + pipe.remove( 0 ) );
            pipe.notifyAll();
        }
    }
}
