package backtracking;

/**
 * @author Dinesh Thangaraj
 *
 *         Created on 12-Feb-2018
 */
public class NQueen {
	public static void main(String[] args) {
		placeQueens(10);
	}

	static void placeQueens(int n) {
		if (n < 4)
			System.out.println("No solution available");
		else {
			boolean[][] board = new boolean[n][n];
			placeAllQueen(board, 0);
			printBoard(board);
		}
	}

	static boolean placeAllQueen(boolean[][] board, int row) {
		if (row == board.length)
			return true;

		boolean allQueensPlaced = false;
		for (int col = 0; col < board.length; col++) {
			if (isSafe(board, row, col)) {
				board[row][col] = true;
				allQueensPlaced = placeAllQueen(board, row + 1);
			}
			if (allQueensPlaced)
				break;
			else
				board[row][col] = false;
		}
		return allQueensPlaced;
	}

	static boolean isSafe(boolean[][] board, int row, int col) {
		// Check Left Upper Diagonal
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
			if (board[i][j])
				return false;
		// Check Right Upper Diagonal
		for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++)
			if (board[i][j])
				return false;
		// Check in same Column
		for (int i = row - 1; i >= 0; i--)
			if (board[i][col])
				return false;
		return true;
	}

	static void printBoard(boolean[][] board) {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++)
				if (board[row][col])
					System.out.print("Q  ");
				else
					System.out.print("-  ");
			System.out.println("");
		}
	}

}
