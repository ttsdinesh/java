import java.util.stream.IntStream;

public class StreamsTest {
	public static void main(String[] args) {
		// IntStream.range(0, 10).forEach(System.out::println);
		boolean failFast = true;

		System.out.println(IntStream.range(0, 10).filter(n -> {
			if (routeSuccess(6))
				return true;
			else
				return false;
		}).findAny().isPresent());
	}

	static boolean routeSuccess(int i) {
		System.out.println("i: " + i);
		return i == 6;
	}
}
