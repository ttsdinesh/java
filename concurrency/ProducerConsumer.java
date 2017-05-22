import java.util.*;

public class ProducerConsumer
{
    public static void main( String[] args )
    {
        List<Integer> list = new ArrayList<>();

        Producer producer = new Producer( list );
        Consumer consumer = new Consumer( list );
        producer.start();
        consumer.start();
    }
}

class Producer
        extends Thread
{
    List<Integer> list = new ArrayList<>();
    Integer max = 8;

    Producer( List<Integer> list )
    {
        this.list = list;
    }

    @Override
    public void run()
    {
        int counter = 0;
        try
        {
            while( true && this.isInterrupted() == false )
            {
                produce( counter++ );
            }
        }
        catch( Throwable e )
        {
            e.printStackTrace();
        }
    }

    void produce( Integer counter ) throws InterruptedException
    {
        synchronized( this.list )
        {
            while( this.list.size() == max )
            {
                System.out.println( "Reached MAX. P waiting for C" );
                this.list.wait();
            }
            this.sleep( 100 );
            this.list.add( counter );
            System.out.println( "P:" + counter );
            this.list.notifyAll();
        }
    }
}

class Consumer
        extends Thread
{
    List<Integer> list = new ArrayList<>();

    Consumer( List<Integer> list )
    {
        this.list = list;
    }

    @Override
    public void run()
    {
        try
        {
            while( true )
            {
                consume();
                this.sleep( 500 );
            }
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }

    void consume() throws InterruptedException
    {
        synchronized( this.list )
        {
            while( this.list.isEmpty() )
            {
                System.out.println( "Empty. D waiting for P" );
                this.list.wait();
            }

            System.out.println( "D:" + this.list.get( 0 ) );
            this.list.remove( 0 );
            this.list.notifyAll();
        }
    }
}

