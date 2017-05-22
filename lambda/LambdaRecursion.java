import java.util.function.UnaryOperator;

/**
 *
 * @author dinesht
 */
public class LambdaRecursion
{
    // This link has more explanation https://dzone.com/articles/do-it-java-8-recursive-lambdas
    static final UnaryOperator<Integer> FACTORIAL = n -> n == 0 ? 1 : n * LambdaRecursion.FACTORIAL.apply( n - 1 );

    public static void main( String[] args )
    {
        System.out.println(LambdaRecursion.FACTORIAL.apply( 10 ) );
    }
}

