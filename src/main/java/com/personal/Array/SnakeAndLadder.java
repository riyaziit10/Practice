package main.java.com.personal.Array;

import java.util.LinkedList;

/**
 * Created by riyaz on 31/7/15.
 */
public class SnakeAndLadder {
    static  class Node {
        int virtex;
        int distance;

        public Node(int virtex, int distance) {
            this.virtex = virtex;
            this.distance = distance;
        }
    }

    static int getMinimumMovesRequireToReachEnd(int [] moves, int k, int N) {
        boolean visited[] = new boolean[N];

        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(new Node(0,0));
        Node temp = null;
        while(!queue.isEmpty()) {
            temp = queue.poll();
            if(temp.virtex == N - 1) {
                System.out.println("Hello" + temp.distance);
                break;
            }
            for(int v = temp.virtex + 1; v <=(temp.virtex + 6) && v < N ; ++v) {
                if(!visited[v]) {
                    if(moves[v] == -1 )
                        queue.add(new Node(v, temp.distance + 1));
                    else
                        queue.add(new Node(moves[v], temp.distance + 1));

                }
            }

        }
        return temp.distance;
    }
    public static void main(String[] args) {
        int N = 30;
        int [] moves = new int[N];
        for(int i = 0 ; i < N; ++i)
            moves[i] = -1;

        // Ladders
        moves[2] = 21;
        moves[4] = 7;
        moves[10] = 25;
        moves[19] = 28;

        // Snakes
        moves[26] = 0;
        moves[20] = 8;
        moves[16] = 3;
        moves[18] = 6;

        System.out.println(getMinimumMovesRequireToReachEnd(moves,6,N));
        System.out.println("Hi");


    }
}
