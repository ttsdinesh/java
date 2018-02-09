package java9;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author Dinesh Thangaraj
 *
 *         Created on 09-Feb-2018
 */
public class CompletableFutureCompleteOnTimeout {
	public static void main(String[] args) throws Exception {
		System.out.println(
				CompletableFuture.supplyAsync(() -> executor()).completeOnTimeout(-1, 4, TimeUnit.SECONDS).get());
	}

	static Integer executor() {
		System.out.println("Executing worker");
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (Exception w) {
		}
		return 0;
	}
}
