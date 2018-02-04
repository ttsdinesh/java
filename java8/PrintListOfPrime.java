import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class PrintListOfPrime {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		list.parallelStream().filter(PrintListOfPrime::isPrime).forEach(System.out::println);
	}

	static boolean isPrime(int number) {
		return number > 1 && IntStream.range(2, number).noneMatch(index -> number % index == 0);
	}
}
