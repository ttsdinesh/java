
import java.util.*;

/**
 *  *
 *   * @author dinesht
 *    */
public class TimerTaskExample
{
    public static void main( String[] args )
    {
        ThreadClass threadClass = new ThreadClass();
        Timer timer = new Timer();

        timer.schedule( threadClass, 1000, 2000 ); // 1000 is the delay and 2000 is the interval at which the thread is executed
    }

    static class ThreadClass
            extends TimerTask
    {
        @Override
        public void run()
        {
            System.out.println( "Thread executed at :" + new Date() );
        }
    }
}

