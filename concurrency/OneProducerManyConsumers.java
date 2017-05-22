import java.util.*;

/**
 *
 * @author dinesht
 */
public class OneProducerManyConsumers
{

    public static void main( String[] args )
    {
        List<Integer> sharedPipe = new ArrayList<>();
        OneProducerManyConsumers.Producer producer = new OneProducerManyConsumers.Producer( sharedPipe );

        OneProducerManyConsumers.Consumer consumer = new OneProducerManyConsumers.Consumer( sharedPipe );

        Thread producerThread = new Thread( producer );
        producerThread.start();

        Thread consumerThreadOne = new Thread( consumer );
        Thread consumerThreadTwo = new Thread( consumer );

        consumerThreadOne.setName( "ConsumerOne" );
        consumerThreadTwo.setName( "ConsumerTwo" );

        consumerThreadOne.start();
        consumerThreadTwo.start();

    }

    static class Producer
            implements Runnable
    {
        List<Integer> pipe;
        int i = 0;

        public Producer( List<Integer> sharedPipe )
        {
            this.pipe = sharedPipe;
        }

        @Override
        public void run()
        {
            try
            {
                while( true )
                {
                    this.produce();
                }
            }
            catch( Exception e )
            {
                System.out.println( "" + e );
            }
        }

        void produce() throws InterruptedException
        {
            synchronized( this.pipe )
            {
                if( this.pipe.size() == 10 )
                {
                    this.pipe.notifyAll();
                    this.pipe.wait();
                }
                Thread.sleep( 500 );
                this.pipe.add( i++ );
                System.out.println( "Produced: " + i );

            }
        }
    }

    static class Consumer
            implements Runnable
    {
        List<Integer> pipe;

        public Consumer( List<Integer> sharedPipe )
        {
            this.pipe = sharedPipe;
        }

        @Override
        public void run()
        {
            try
            {
                while( true )
                {
                    consume();
                    Thread.sleep( 800 );
                }
            }
            catch( Exception e )
            {
                System.out.println( "" + e );
            }

        }

        void consume() throws InterruptedException
        {
            synchronized( this.pipe )
            {
                while( this.pipe.isEmpty() )
                {
                    this.pipe.wait();
                }

                System.out.println( Thread.currentThread().getName() + ": " + this.pipe.remove( 0 ) );
                this.pipe.notifyAll();
            }
        }
    }

}

