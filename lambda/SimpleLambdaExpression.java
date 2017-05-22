/**
 *
 * @author dinesht
 */
public class SimpleLambdaExpression
{
    public static void main( String[] args )
    {
        //Runnable task = () -> System.out.println( "" );
        Runnable task = () -> 
                {
                    for( int i = 0; i < 10; i++ )
                    {
                        System.out.println( "Thread " + i );
                        try
                        {
                            Thread.sleep( 100 );
                        }
                        catch( Exception e )
                        {
		            System.out.println( "Exception: " + e );
                        }
                    }
        };
        /* Equivalent of the below code
         new Runnable(){      
	         @Override
	         public void run(){
		         System.out.println("Hello world one!");
	         }
         };
         */

        Thread t = new Thread( task );
        t.start();
    }
}

