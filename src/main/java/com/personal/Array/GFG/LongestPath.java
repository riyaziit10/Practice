package main.java.com.personal.Array.GFG;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by riyaz on 28/8/15.
 */
public class LongestPath {

    private static final int x[] = {0, 1, 1, -1, 1, 0, -1, -1};
    private static final int y[] = {1, 0, 1, 1, -1, -1, 0, -1};
    private static boolean isSafe(char [][] mat, int i, int j) {
        int M = mat.length;
        int N = mat[0].length;
        if(i < 0 || i >= M)
            return false;
        else if(j < 0 || j >= N)
            return false;
        return true;
    }
    private static void findPath(char [][] mat,char ch, int m , int n, List<Character> result) {
        for(int i = 0; i < 8; ++i) {
            int a = m + x[i];
            int b = n + y[i];
                if(isSafe(mat, a, b) && mat[a][b] == ch + 1) {
                    result.add(mat[a][b]);
                    findPath(mat, mat[a][b], a, b, result);
                }
        }
    }
    private static void findLongestPath(char mat[][], char k) {
        if(mat == null || mat.length == 0)
            return;
        int M = mat.length;
        int N = mat[0].length;
        List<Character> finalResult = new ArrayList<Character>();
        for(int i  = 0 ;i < M ; ++i) {
            List<Character> temp = new ArrayList<Character>();
            for(int j = 0; j < N ; ++j) {
              if(mat[i][j] == k) {
                  temp.add(k);
                    findPath(mat, k, i, j, temp);
                  if(temp.size() > finalResult.size()) {
                      finalResult.addAll(temp);
                  }
              }
            }
        }
        Iterator it = finalResult.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
    public static void main(String[] args) {
        char mat[][] = {    {'a', 'c', 'd'},
                            {'h', 'b', 'a'},
                            {'i', 'g', 'f'}
                        };
        findLongestPath(mat, 'a');
    }
}
