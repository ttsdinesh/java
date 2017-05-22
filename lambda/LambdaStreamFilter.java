import java.util.*;

/**
 *
 * @author dinesht
 */
public class LambdaStreamFilter
{
    public static void main( String[] args )
    {
        List<Integer> numbers = Arrays.asList( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 );
        numbers.stream()
                .filter( LambdaStreamFilter::GT5 ) // Numbers greater than 5
                .filter( n -> n % 2 == 0 ) // Only even numbers
                .forEach( System.out::println );
    }

    static boolean GT5( int i )
    {
        return i > 5;
    }
}
