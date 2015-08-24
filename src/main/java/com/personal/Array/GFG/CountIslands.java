package main.java.com.personal.Array.GFG;

/**
 * Created by riyaz on 22/8/15.
 */

public class CountIslands {
    private static boolean isSafe(int mat[][], int x, int y) {
        int M = mat.length;
        int N = mat[0].length;
        if(x >= M || x < 0)
            return false;
        if(y >= N || y < 0)
            return false;
        if(mat[x][y] == 0)
            return false;
        return true;
    }

    private static void DFS(int mat[][], int r, int c, boolean [][] visited) {
        visited[r][c] = true;
        int rIncrement [] = {-1,-1,-1,0,0, 1, 1,1};
        int cIncrement [] = {-1, 0, 1,-1,1, -1,0,1};
        for(int k = 0; k < 8; ++k) {
            int i = r + rIncrement[k];
            int j = c + cIncrement[k];
            if(isSafe(mat,i,j) && !visited[i][j]) {
                DFS(mat, i, j, visited);
            }
        }
    }
    private static void getNumberOfIslands(int mat[][]) {
        if(mat == null || mat.length == 0)
            return;
        int M = mat.length;
        int N = mat[0].length;
        boolean isVisited [][] = new boolean[M][N];
        int count = 0;

        for(int i = 0; i < M; ++i) {
            for(int j = 0; j < N; ++j) {
                if(mat[i][j] == 1 && !isVisited[i][j]) {
                    DFS(mat, i, j , isVisited);
                    ++count;
                }
            }
        }
        System.out.println("Number of islands \t" + count);
    }
    public static void main(String[] args) {
        int mat[][]= {  {1, 1, 0, 0, 0},
                        {0, 1, 0, 0, 1},
                        {1, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0},
                        {1, 0, 1, 0, 1}
        };
        getNumberOfIslands(mat);
    }
}
