
/**
 *  *
 *   * @author dinesht
 *    */
public class DeadlockExample
{
    public static void main( String[] args )
    {
        Object object1 = new Object();
        Object object2 = new Object();

        Producer producer = new Producer( object1, object2 );
        Consumer consumer = new Consumer( object1, object2 );

        producer.start();
        consumer.start();

    }

    static class Producer
            extends Thread
    {
        Object object1;
        Object object2;

        public Producer( Object obj1, Object obj2 )
        {
            this.object1 = obj1;
            this.object2 = obj2;
        }

        @Override
        public void run()
        {
            synchronized( this.object1 )
            {
                try
                {
                    System.out.println( "Producer acquired lock on object1 and waiting for lock on object2" );
                    Thread.sleep( 200 ); // Chance of deadlock is less if there is no sleep
                }
                catch( Exception e )
                {
                    System.out.println( "Exception" + e );
                }
                synchronized( this.object2 )
                {
                    System.out.println( "Producer acquired lock on object2" );
                }
            }
        }

    }

    static class Consumer
            extends Thread
    {
        Object object1;
        Object object2;

        public Consumer( Object obj1, Object obj2 )
        {
            this.object1 = obj1;
            this.object2 = obj2;
        }

        @Override
        public void run()
        {
            synchronized( this.object2 )
            {
                try
                {
                    System.out.println( "Consumer acquired lock on object2 and waiting for lock on object1" );
                    Thread.sleep( 200 ); // Chance of deadlock is less if there is no sleep
                }
                catch( Exception e )
                {
                    System.out.println( "Exception" + e );
                }
                synchronized( this.object1 )
                {
                    System.out.println( "Consumer acquired lock on object1" );
                    System.out.println( "Inside Consumer" );
                }
            }
        }
    }
}

