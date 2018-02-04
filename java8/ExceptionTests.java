import java.util.stream.IntStream;

public class ExceptionTests {
	public static void main(String[] args) {
		IntStream.range(0, 1).forEach(n -> {
			try {
				print();
			} catch (Exception e) {
				throw new RuntimeException();
			}
		});
	}

	static void print() throws Exception {
		System.out.println("print");
		throw new Exception("Exception in print");
	}

}
