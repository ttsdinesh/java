import java.util.concurrent.CompletableFuture;

/**
 * @author Dinesh Thangaraj
 *
 *         Created on 04-May-2017
 */
public class CompletableFutureChainOfActions {
	private String msg(String msg, CompletableFutureChainOfActionsObject obj) {
		System.out.println("Msg: " + msg);
		obj.setMsg(msg);
		return msg;
	}

	private String msg1(String msg, CompletableFutureChainOfActionsObject obj) {
		System.out.println("Msg1: " + msg);
		msg = msg + ":" + System.currentTimeMillis();
		obj.setMsg(msg);
		return msg;
	}

	public static void main(String[] args) {
		CompletableFutureChainOfActions obj = new CompletableFutureChainOfActions();
		String str = "HI";
		CompletableFutureChainOfActionsObject obj1 = new CompletableFutureChainOfActionsObject();
		CompletableFuture
				// Call msg
				.supplyAsync(() -> obj.msg(str, obj1))
				// Call msg1
				.thenAcceptAsync(result -> {
					System.out.println("Result: " + result);
					if (result != null)
						obj.msg1(result, obj1);
				})
				// Finally print
				.thenRunAsync(System.out::println);
	}
}

class CompletableFutureChainOfActionsObject {
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
