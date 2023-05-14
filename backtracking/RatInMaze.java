package backtracking;

import java.util.*;

//  pathmatrix: to avoid revisit same cell maze matix original matrix
public class RatInMaze {
    public static boolean ratinmazeproblem(int maze[][]) {
        int n = maze.length;
        int path[][] = new int[n][n];
        return solvemaze(maze, 0, 0, path);
    }

    public static boolean solvemaze(int maze[][], int i, int j, int[][] path) {
        if (i < 0 || i >= maze.length || j < 0 || j >= maze.length || maze[i][i] == 0 || path[i][j] == 1) {
            return false;
        }
        path[i][j] = 1;
        if (i == maze.length - 1 && j == maze.length - 1) {
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

    public static void main(String[] args) {
        int maze[][] = { { 1, 1, 0 }, { 1, 0, 1 }, { 0, 1, 1 } };
        boolean PathExist = ratinmazeproblem(maze);
        System.out.println(PathExist);
    }
}
