import java.util.concurrent.CompletableFuture;

/**
 * @author Dinesh Thangaraj
 *
 *         Created on 11-May-2017
 */
public class SimpleCompletableFutureExample {
	public static void main(String[] args) throws Exception {
		CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
			return "Hello";
		});
		System.out.println(cf.get());
	}
}
