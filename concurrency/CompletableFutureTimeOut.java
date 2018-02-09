package java9;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author Dinesh Thangaraj
 *
 *         Created on 08-Feb-2018
 */
public class CompletableFutureTimeOut {
	public static void main(String[] args) throws Exception {
		CompletableFuture.supplyAsync(() -> CompletableFutureTimeOut.worker()).orTimeout(2, TimeUnit.SECONDS)
				.whenCompleteAsync((result, exception) -> {
					if (exception == null)
						System.out.println("Execution done");
					else
						System.out.println("Timed out");
				}).get(); // block and print the output
	}

	static Integer worker() {
		System.out.println("Executing worker");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (Exception w) {
		}
		return 0;
	}
}
