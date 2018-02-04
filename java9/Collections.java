import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Dinesh Thangaraj
 *
 *         Created on 20-Sep-2017
 */
public class Collections {
	public static void main(String[] args) {
		List<String> list = List.of("a", "b", "c");
		System.out.println(list);
		Set<String> set = Set.of("a", "b", "c");
		System.out.println(set);
		Map<String, Integer> map = Map.of("one", 1, "two", 2, "three", 3);
		System.out.println(map);
	}
}
