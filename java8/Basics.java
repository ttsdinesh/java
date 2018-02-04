public class Basics {
	public static void main(String[] args) {
		Sum summation = (int x, int y) -> x + y;
		System.out.println(summation.sum(2, 3));
		summation.print();

		Divide division = (x, y) -> {
			try {
				return x / y;
			} catch (ArithmeticException ex) {
				System.out.println("Arithmetic exception. " + ex);
			}
			return 0;
		};

		System.out.println(division.divide(2, 3));
		System.out.println(division.divide(0, 0));
	}

	@FunctionalInterface // Optional
	interface Sum {
		int sum(int x, int y);

		default void print() {
			System.out.println("Inside sum");
		}
	}

	interface Divide {
		int divide(int x, int y);
	}
}
