package backtracking;

import java.util.*;

//  pathmatrix: to avoid revisit same cell maze matix original matrix
public class ratprint {
    public static boolean ratinmazeproblem(int maze[][]) {
        int n = maze.length;
        int path[][] = new int[n][n];
        return solvemaze(maze, 0, 0, path);

    }

    public static void allpathrat(int maze[][]) {
        int n = maze.length;
        int path[][] = new int[n][n];
        print(maze, 0, 0, path);

    }

    public static boolean solvemaze(int maze[][], int i, int j, int[][] path) {
        int n = maze.length;
        if (i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1) {
            return false;
        }
        path[i][j] = 1;
        if (i == n - 1 && j == n - 1) {
            for (int k = 0; k < n; k++) {
                for (int l = 0; l < n; l++) {
                    System.out.print(path[k][l] + " ");
                }
                System.out.println();
            }
            return true;
        }
        // top
        if (solvemaze(maze, i - 1, j, path)) {
            return true;
        }
        ;
        // right
        if (solvemaze(maze, i, j + 1, path)) {
            return true;
        }
        // down
        if (solvemaze(maze, i + 1, j, path)) {
            return true;
        }
        // left
        if (solvemaze(maze, i, j - 1, path)) {
            return true;
        }
        return false;

    }

    public static void print(int maze[][], int i, int j, int[][] path) {
        int n = maze.length;
        if (i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1) {
            return;
        }
        path[i][j] = 1;
        if (i == n - 1 && j == n - 1) {
            System.out.println("_________________");
            System.out.println();
            for (int k = 0; k < n; k++) {
                for (int l = 0; l < n; l++) {
                    System.out.print(path[k][l] + " ");
                }
                System.out.println();
            }

            path[i][j] = 0;
            return;
        }
        // top
        print(maze, i - 1, j, path);
        print(maze, i, j + 1, path);
        print(maze, i + 1, j, path);
        print(maze, i, j - 1, path);
        path[i][j] = 0;

    }

    public static void main(String[] args) {
        System.out.println("_________________");
        int maze[][] = { { 1, 1, 0 }, { 1, 1, 0 }, { 1, 1, 1 } };
        System.out.println(" path  ");
        boolean ans = ratinmazeproblem(maze);
        System.out.println("there is path ? " + ans);
        System.out.println("---------------");
        allpathrat(maze);
    }
}
// path
// 1 1 0
// 0 1 0
// 0 1 1
// there is path ? true
// ---------------
// _________________

// 1 1 0
// 0 1 0
// 0 1 1
// _________________

// 1 1 0
// 1 1 0
// 1 1 1
// _________________

// 1 0 0
// 1 1 0
// 0 1 1
// _________________

// 1 0 0
// 1 0 0
// 1 1 1