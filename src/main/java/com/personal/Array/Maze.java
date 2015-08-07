package main.java.com.personal.Array;

import java.util.LinkedList;

class Maze {
    static class Node {
        int i;
        int j;
        int move;

        public Node(int i, int j) {
            this(i, j, 0);
        }

        public Node(int i, int j, int m) {
            this.i = i;
            this.j = j;
            this.move = m;
        }
    }

    static void printMaze(boolean[][] maze) {
        int m = maze.length;
        int n = maze[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.print(maze[i][j] + "\t");
            }
            System.out.println();
        }
    }

    static boolean isSafe(boolean[][] maze, int x, int y) {
        if (x >= maze.length || x < 0 || y >= maze[0].length || y < 0)
            return false;
        return maze[x][y];
    }

    static void printPath(boolean[][] maze) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Node[][] levelOrder = new Node[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                levelOrder[i][j] = new Node(i, j, 0);
            }
        }
        Node[] directions = {new Node(1, -1), new Node(0, -1), new Node(-1, -1), new Node(-1, 0), new Node(-1, -1), new Node(0, 1), new Node(1, 1), new Node(1, 0)};
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(new Node(0, 0));
        visited[0][0] = true;
        Node temp = null;
        boolean flag = false;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            if (temp.i == m - 1 && temp.j == n - 1) {
                flag = true;
                System.out.println("Path size is\t" + temp.move);
            }

            for (int i = 0; i < 8; ++i) {
                int x = temp.i + directions[i].i;
                int y = temp.j + directions[i].j;
                if (isSafe(maze, x, y)) {
                    if (!visited[x][y]) {
                        visited[x][y] = true;
                        queue.add(new Node(x, y, temp.move + 1));
                        levelOrder[x][y].move = temp.move + 1;
                    }
                }
            }
        }
        if (flag == false) {
            System.out.println("Path can not be found");
            return;
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.print(levelOrder[i][j].move + " ");
            }
            System.out.println();
        }

        int i = m - 1;
        int j = n - 1;
        LinkedList<Node> path = new LinkedList<Node>();
        path.add(new Node(i,j));
        while(i != 0 || j != 0) {
            for(int k = 0; k < 8 ; ++k){
                int ii = i + directions[k].i;
                int jj = j + directions[k].j;
                if( ii >=0 && ii < m && jj >= 0 && jj < n){
                    if(levelOrder[ii][jj].move == levelOrder[i][j].move - 1) {
                        path.add(0,new Node(ii,jj));
                        i = ii;
                        j = jj;
                        break;
                    }
                }
            }
        }
        for(Node node : path) {
            System.out.println("(" + node.i + "," + node.j + ")");
        }

    }

    static void printMinimumpath(boolean[][] maze) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(new Node(0, 0));
        Node[] directions = {new Node(1, -1), new Node(0, -1), new Node(-1, -1), new Node(-1, 0), new Node(-1, -1), new Node(0, 1), new Node(1, 1), new Node(1, 0)};
        Node temp = null;
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            temp = queue.poll();
//            System.out.println("(" + temp.i + "," + temp.j + "," + temp.move + ")");
            if (temp.i == m - 1 && temp.j == n - 1) {
                System.out.println(temp.move);
                return;
            }
            for (int i = 0; i < 8; ++i) {
                int x = temp.i + directions[i].i;
                int y = temp.j + directions[i].j;
                if (isSafe(maze, x, y)) {
                    if (!visited[x][y]) {
                        visited[x][y] = true;
                        queue.add(new Node(x, y, temp.move + 1));
                    }
                }
            }
        }
        System.out.println("Not possible");

    }

    public static void main(String[] args) {
        boolean[][] maze = {
                {true, true, true, true},
                {true, true, false, true},
                {true, false, false, false},
                {true, true, true, true}};

        printMaze(maze);
//        printMinimumpath(maze);
        printPath(maze);
    }
}