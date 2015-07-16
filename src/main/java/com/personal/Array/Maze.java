package Array;

/**
 * Created by riyaz on 4/7/15.
 */
public class Maze {
    static void makeRandomMaze(boolean[][] maze) {
        int length = maze.length;
        for (int i = 0; i < length; ++i) {
            for (int j = 0; j < maze[i].length; ++j) {
                maze[i][j] = (int) (Math.random() * 3) == 1;
            }
        }
        maze[0][0] = false;
        maze[maze.length - 1][maze[0].length - 1] = false;
        printMaze(maze);
    }

    static boolean isSafe(boolean[][] maze, int i, int j) {
        return i >= 0 && j >= 0 && i < maze.length && j < maze.length && maze[i][j] == false;

    }

    static void printMaze(boolean[][] maze) {
        int length = maze.length;
        for (int i = 0; i < length; ++i) {
            for (int j = 0; j < maze[i].length; ++j)
                if (maze[i][j])
                    System.out.print("#|");
                else
                    System.out.print("_|");

            System.out.println();
        }
    }

    static class Points {
        int i;
        int j;

        public Points(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    static void show(Points [] pointse) {
        System.out.println();
        for(Points p :pointse) {
            if(p != null)
                System.out.print("(" + p.i + " , " + p.j + ")");
        }
    }
    static void findPaths(boolean[][] maze, int i, int j, boolean [] [] visited, Points [] p, int index) {
        int length = maze.length;
        if(i == length - 1 && j == length - 1) {
            p[index] = new Points(i,j);
            show(p);
            return;
        }
        if (isSafe(maze, i, j)) {
            visited[i][j] = true;
            p[index] = new Points(i,j);
            findPaths(maze, i, j + 1, visited, p, index + 1);
            findPaths(maze, i + 1, j, visited, p,  index + 1);
            visited[i][j]= false;
        }
    }

    public static void main(String[] args) {
        int m = 4, n = 4;
        boolean[][] maze = new boolean[m][n];
        makeRandomMaze(maze);
        boolean [][] visited = new boolean[m][n];
//        printMaze(visited);
        Points [] pointse = new Points[m+n];
        findPaths(maze,0,0,visited, pointse, 0);
    }
}
