import java.util.function.Predicate;

/**
 *
 * @author dinesht
 */
public class LambdaExpressionPalindrome
{
    public static void main( String[] args )
    {
        Predicate checkForPalindrome = (peyar)
                -> 
                {
                    return peyar.equals( new StringBuilder( peyar.toString() ).reverse().toString() ); // predicate should always return a value
        };

        System.out.println( checkForPalindrome.test( "LIRIL" ) );
        System.out.println( checkForPalindrome.test( "DINESH" ) );
    }
}

