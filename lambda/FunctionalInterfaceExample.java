/**
 *
 * @author dinesht
 */
public class FunctionalInterfaceExample
{
    public static void main( String[] args )
    {
        Sum summation = (x, y) -> x + y;

        Div division = (x, y)
                -> 
                {
                    try
                    {
                        return x / y;
                    }
                    catch( ArithmeticException e )
                    {
                        System.out.println( "Exception Occured: " + e );
                    }
                    return 0; // return statement is compulsory since an exception in try block will result in no value returned
        };

        System.out.println( division.div( 12, 0 ) );
        System.out.println( summation.sum( 12, 13 ) );
    }
}

@FunctionalInterface // Optional
interface Sum
{
    int sum( int x, int y );

    //int diff( int x, int y ); // With @FunctionalInterface this method definition will throw compiler error. Hence commented
}

@FunctionalInterface // Optional
interface Div
{
    int div( int x, int y ) throws ArithmeticException;
}

