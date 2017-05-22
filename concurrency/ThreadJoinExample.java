
/**
 *  *
 *   * @author dinesht
 *    */
public class ThreadJoinExample
{
    public static void main( String[] args )
    {
        ThreadClass t = new ThreadClass();
        t.start();

        try
        {
            System.out.println( "Waiting for 500ms for the child thread to complete and join with the main thread" );
            t.join( 500 );
            System.out.println( "Waiting indefinitely for the child thread to complete and join with the main thread" );
            t.join();

        }
        catch( Exception e )
        {
            System.out.println( "Exception occured:" + e );
        }
        System.out.println( "Main Thread executed" );
    }

    static class ThreadClass
            extends Thread
    {
        @Override
        public void run()
        {
            try
            {
                System.out.println( "Child thread sleeping for 2 second" );
                Thread.sleep( 2000 );
            }
            catch( Exception e )
            {
                System.out.println( "Exception occured:" + e );
            }
        }
    }
}

