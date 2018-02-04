import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		PredicateExample.eval(list, n -> (n & 1) == 0);
	}

	static void eval(List<Integer> list, Predicate<Integer> predicate) {
		for (Integer i : list) {
			System.out.println(predicate.test(i));
		}
	}
}
