public class PrimeNumber {
	public static void main(String[] args) {
		System.out.println(new PrimeNumber().isPrime(Integer.MAX_VALUE));
	}

	private boolean isPrime(int n) {

		if (n == 2 || n == 3) {
			return true;
		}

		if (n % 2 == 0 || n % 3 == 0) {
			return false;
		}

		int top = (int) Math.sqrt(n);

		for (int i = 3; i < top; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}
}

