package java9;

import java.util.stream.IntStream;

/**
 * @author Dinesh Thangaraj
 *
 *         Created on 12-Feb-2018
 */
public class DropWhileTakeWhileIterate {
	public static void main(String[] args) {
		IntStream.range(0, 10).takeWhile(x -> x < 5).forEach(System.out::println);
		IntStream.range(0, 10).dropWhile(x -> x < 5).forEach(System.out::println);
		IntStream.iterate(0, x -> x < 10, x -> x + 1).forEach(System.out::println);
	}
}
