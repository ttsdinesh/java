
import java.util.Arrays; 
import java.util.List;
import java.util.function.IntPredicate; 
import java.util.stream.IntStream; 

/**
 *
 * @author dinesht
 */
public class LambdaParallelStream
{
    public static void main( String[] args )
    {
        List<Integer> numbers = Arrays.asList( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 );

        numbers.parallelStream() // change this to stream and the output will be in order
                .filter( number -> isPrime( number ) )
                .forEach( System.out::println ); // The output is not necessarily in the order 2,3,5,7 since it is runs in parallel
    }

    public static boolean isPrime( int number )
    {
        IntPredicate isDivisible = index -> number % index == 0;
        return number > 1 && IntStream.range( 2, number ).noneMatch( isDivisible );
    }
}

