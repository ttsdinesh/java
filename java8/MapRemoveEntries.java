import java.util.HashMap;
import java.util.Map;

public class MapRemoveEntries {
	public static void main(String[] args) {
		Map<Long, Long> map = new HashMap<Long, Long>();
		map.put(5l, 1l);
		map.put(6l, 2l);
		map.put(7l, 3l);

		map.values().removeIf(l -> (l <= 3));
		System.out.println(map);
	}
}
