import java.util.*;

/**
 *
 * @author dinesht
 */
public class SimpleLambdaExpression1
{
    public static void main( String[] args )
    {
        List<Integer> numbers = Arrays.asList( 1, 2, 3, 4, 5, 6, 7, 8, 9 );

        // Conventional for loop
	 numbers.stream().
                forEach( (n) ->
        {
            doubleAndPrint( n );
        } );

        // Using Lambda Expressions
        numbers.forEach( e -> doubleAndPrint( e ) );

        // Using Lambda Expressions and Java 8 APIs. map() API doubles the number
        numbers.stream()
                .map( e -> e * 2 )
                //.map( e -> "Number is: " + e * 2 ) // Map can also append String to the map items
                .forEach( System.out::println );
    }

    static void doubleAndPrint( int number )
    {
        System.out.println( number * 2 );
    }
}
