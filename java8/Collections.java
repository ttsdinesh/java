import java.util.Arrays;
import java.util.List;

public class Collections {
	public static void main(String[] args) {
		String[] str = { "A", "B", "C" };
		List<String> list = Arrays.asList(str);

		StringBuilder sb = new StringBuilder();
		list.forEach(item -> sb.append(item).append("','"));

		System.out.println("" + sb.toString());
	}
}
