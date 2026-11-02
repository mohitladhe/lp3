import java.util.Scanner;

public class Prac5_DAA {

    static int n;
    static int[][] board;

    // Check whether queen can be placed
    static boolean isSafe(int row, int col) {

        // Check same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0;
             i--, j--) {

            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n;
             i--, j++) {

            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    // Backtracking function
    static boolean solve(int row) {

        // All queens placed
        if (row == n) {
            return true;
        }

        // Try every column
        for (int col = 0; col < n; col++) {

            if (isSafe(row, col)) {

                board[row][col] = 1;

                if (solve(row + 1)) {
                    return true;
                }

                // Backtrack
                board[row][col] = 0;
            }
        }

        return false;
    }

    static void printBoard() {

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of N: ");
        n = sc.nextInt();

        board = new int[n][n];

        // Place first queen at (0, 0)
        board[0][0] = 1;

        // Start placing remaining queens
        if (solve(1)) {

            System.out.println("\nN-Queens Solution:");
            printBoard();

        } else {

            System.out.println("No solution exists.");
        }
    }
}








// N-Queens Problem Using Backtracking

// Theory
// The N-Queens Problem is the problem of placing N queens on an N × N chessboard such that no two queens attack each other.

// Two queens cannot be placed in the same:
// - Row
// - Column
// - Diagonal

// In this program, the first queen is placed initially, and then the remaining queens are placed using backtracking.


// Backtracking Approach
// 1. Create an N × N chessboard.
// 2. Place the first queen at a fixed position, such as (0, 0).
// 3. Try to place the next queen in each column.
// 4. Check whether the position is safe.
// 5. If safe, place the queen and move to the next column.
// 6. If no safe position is available, backtrack and remove the previously placed queen.
// 7. Continue until all N queens are placed.


// Objective
// To place N queens on an N × N chessboard using backtracking such that no two queens attack each other.