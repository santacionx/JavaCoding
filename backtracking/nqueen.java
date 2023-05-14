package backtracking;

import java.util.*;

// nxn chess board place n queens no queens attacks each other
public class nqueen {

    public static void placeNqueen(int n) {
        int board[][] = new int[n][n];
        // which row to place queen
        placeNqueen(board, 0, n);
    }

    public static void placeNqueen(int board[][], int row, int n) {
        //
        if (row == n) {
            // print board here the valid board config
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        // check for all columns 1. top 2. upper left - 3.  diagonal 
        // check is safe to place queen
        // place the queen and move to next row
        for (int j = 0; j < n; j++) {
            if (isboardSafe(board, row, j)) {
                // queen is placed
                board[row][j] = 1;
                placeNqueen(board, row + 1, n);
                // queen is not placed
                board[row][j] = 0;
            }
        }

    }

    // checks to place the right place to place queen
    public static boolean isboardSafe(int board[][], int row, int col) {
        int n = board.length;
        // side 1 (-x,-y) upper left
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        // side1 down (x+1,y+1) 
        for (int i = row + 1, j = col + 1; i < n && j < n; i++, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        // side2 up (x-1,y+1)
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        // side2 down (x+1,y-1) upper right
        for (int i = row + 1, j = col - 1; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        // top (x-1,col)
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 1) {
                return false;
            }
        }
        // bottom (x+1,col)
        for (int i = row + 1; i < n; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        placeNqueen(4);
    }
}
// o/p
// 0 1 0 0
// 0 0 0 1
// 1 0 0 0
// 0 0 1 0

// 0 0 1 0
// 1 0 0 0
// 0 0 0 1
// 0 1 0 0
