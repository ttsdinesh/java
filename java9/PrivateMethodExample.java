package java9;

import java.net.UnknownHostException;

/**
 * @author Dinesh Thangaraj
 *
 *         Created on 10-Feb-2018
 */
public interface PrivateMethodExample {
	default void defaultMethod() {
		System.out.println("This is a default method. Hostname: " + getHostname());
	}

	private String getHostname() {
		try {
			return java.net.InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return "localhost";
	}
}
