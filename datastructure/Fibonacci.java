import java.math.BigInteger;
import java.util.Map;
import java.util.HashMap;

public class Fibonacci
{
	public static void main(String[] args)
	{
		int n = 10;
		System.out.println(fibonacciMethod1(n));
		System.out.println(fibonacciMethod2(n));

		System.out.println(fibonacciMethod3(8181));
		System.out.println(fibonacciMethod4(35));
		System.out.println(fibonacciMethod5(40));
		System.out.println(fibonacciMethod6(8181));
	}

	private static int fibonacciMethod1(int n)
	{
		if (n <= 1)
		{
			return n;
		}
		return fibonacciMethod1(n - 1) + fibonacciMethod1(n - 2);
	}

	private static int fibonacciMethod2(int n)
	{
		int[] f = new int[n + 1];
		int i;
		f[0] = 0;
		if (n > 0)
		{
			f[1] = 1;
			for (i = 2; i <= n; i++)
			{
				f[i] = f[i - 1] + f[i - 2];
			}
		}
		return f[n];
	}

	private static BigInteger fibonacciMethod3(int n)
	{
		BigInteger[] f = new BigInteger[n + 1];
		int i;
		f[0] = BigInteger.ZERO;
		if (n > 0)
		{
			f[1] = BigInteger.ONE;
			for (i = 2; i <= n; i++)
			{
				f[i] = f[i - 1].add(f[i - 2]);
			}
		}
		return f[n];
	}

	// Not the faster one. Will take too much of time to calculate beyond 40+
	private static BigInteger fibonacciMethod4(Integer n)
	{
		if (n <= 1)
		{
			return BigInteger.valueOf(n.intValue());
		}
		return fibonacciMethod4(n - 1).add(fibonacciMethod4(n - 2));
	}

	// Efficient than fibonacciMethod4 but might cause java.lang.StackOverflowError
	private static Map<Integer, BigInteger> precomputedValues = new HashMap<Integer, BigInteger>();

	private static BigInteger fibonacciMethod5(Integer n)
	{
		if (n <= 1)
		{
			return BigInteger.valueOf(n.intValue());
		}

		if (precomputedValues.containsKey(n))
		{
			return precomputedValues.get(n);
		}
		BigInteger sum = fibonacciMethod5(n - 1).add(fibonacciMethod5(n - 2));
		precomputedValues.put(n, sum);
		return sum;
	}

	private static BigInteger fibonacciMethod6(int n)
	{
		BigInteger zero = BigInteger.ZERO;
		BigInteger one = BigInteger.ONE;
		BigInteger sum = BigInteger.ONE;
		for (int i = 2; i <= n; i++)
		{
			sum = zero.add(one);
			zero = one;
			one = sum;
		}
		return sum;
	}
}

