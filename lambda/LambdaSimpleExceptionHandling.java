
import java.util.*;
import java.util.stream.IntStream;

/**
 *
 * @author dinesht
 */
public class LambdaSimpleExceptionHandling
{
    public static void main( String[] args )
    {
        List<Integer> numbers = Arrays.asList( 1, 2, 3, 4, 5, 6, 7 );

        numbers.forEach( n -> 
                {
                    try
                    {
                        print( n );
                    }
                    catch( Exception e )
                    {
                        System.out.println( "Exception message: " + e.getMessage() );
                    }
                } );
    }

    static void print( int i ) throws Exception
    {
        if( i == 3 )
        {
            throw new Exception( "Custom Error Message" );
        }
    }
}
