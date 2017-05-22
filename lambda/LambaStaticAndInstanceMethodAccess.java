
import java.util.*;

/**
 *
 * @author dinesht
 */
public class LambaStaticAndInstanceMethodAccess
{
    public static void main( String[] args )
    {

        LambaStaticAndInstanceMethodAccess instance = new LambaStaticAndInstanceMethodAccess();
        List<Integer> numbers = Arrays.asList( 1, 2, 3, 4, 5 );

        numbers.stream()
                .filter( LambaStaticAndInstanceMethodAccess::isEven ) // Accessing static method 
                .forEach( instance::print ); // Accessing instance method
    }

    public static boolean isEven( int i )
    {
        return i % 2 == 0;
    }

    public void print( int i )
    {
        System.out.println( i );
    }
}

