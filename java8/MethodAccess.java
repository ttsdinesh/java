import java.util.Arrays;
import java.util.List;

public class MethodAccess {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		list.stream().filter(MethodAccess::isEven).forEach(MethodAccess::print);
	}

	static boolean isEven(int i) {
		return (i & 1) == 0;
	}

	static void print(int i) {
		System.out.println(i);
	}
}
