import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Dinesh Thangaraj
 *
 *         Created on 23-Mar-2018
 */
public class LocalVarExample {
	public static void main(String[] args) {
		var s = "Dinesh";
		System.out.println(s);
		var map = Map.of(1, "ONE", 2, "TWO", 3, "THREE");
		System.out.println(map);
		// map.put(4, 4); // Compile time exception

		// var arr = { 1, 2, 3 }; // Compile time exception
		// Arrays.toString(arr);
		
		print(s);

		var customObject = new CustomObject();
		customObject.setId(10);
		System.out.println(customObject.getId());
	}

	// static void print(var v) { // Compile time exception
	//
	// }

	static void print(String s) {
		var v = s;
		System.out.println(v);
	}
}

class CustomObject {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}