package main.java.com.personal.Company;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Points {
    int x;
    int y;

    public Points(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Board {
    List<Points> availablePoints;
    Scanner scan = new Scanner(System.in);
    int[][] board = new int[3][3];
    Points computersMove;

    public boolean hasXwon() {
        int x = 1;
        if ((board[0][0] == board[1][1]) && (board[0][0] == board[2][2]) && (board[0][0] == x) ||
                board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == x) {
            return true;
        }

        for (int i = 0; i < 3; ++i) {
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == x ||
                    board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == x) {
                return true;
            }
        }
        return false;
    }

    public boolean hasOwon() {
        int x = 2;
        if ((board[0][0] == board[1][1]) && (board[0][0] == board[2][2]) && (board[0][0] == x) ||
                board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == x) {
            return true;
        }

        for (int i = 0; i < 3; ++i) {
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == x ||
                    board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == x) {
                return true;
            }
        }
        return false;
    }

    public List<Points> getAvailableStates() {
        availablePoints = new ArrayList<Points>();
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (board[i][j] == 0) {
                    availablePoints.add(new Points(i, j));
                }
            }
        }
        return availablePoints;
    }

    public boolean isGameOver() {
        return (hasXwon() || hasOwon() || getAvailableStates().isEmpty());
    }

    public void placeMove(Points point, int player) {
        board[point.x][point.y] = player;
    }

    public void displayBoard() {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (board[i][j] == 1)
                    System.out.print("X" + "\t");
                else if (board[i][j] == 2)
                    System.out.print("O" + "\t");
                else System.out.print("_" + "\t");
            }
            System.out.println();
        }
    }

    public int minimax(int depth, int turn) {
        if (hasXwon()) return +1;
        if (hasOwon()) return -1;
        List<Points> pointsAvailable = getAvailableStates();
        if (pointsAvailable.isEmpty()) return 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < pointsAvailable.size(); ++i) {
            Points point = pointsAvailable.get(i);
            if (turn == 1) {
                placeMove(point, 1);
                int currentScore = minimax(depth + 1, 2);
                max = Math.max(currentScore, max);
                if (currentScore >= 0) {
                    if (depth == 0) computersMove = point;
                }
                if (currentScore == 1) {
                    board[point.x][point.y] = 0;
                    break;
                }
                if (i == pointsAvailable.size() - 1 && max < 0) {
                    if (depth == 0) computersMove = point;
                }
            } else if (turn == 2) {
                placeMove(point, 2);
                int currentScore = minimax(depth + 1, 1);
                min = Math.min(currentScore, min);
                if (min == -1) {
                    board[point.x][point.y] = 0;
                    break;
                }
            }
            board[point.x][point.y] = 0;
        }
        return turn == 1 ? max : min;
    }

    public boolean isLegalMove(int x, int y) {
        if (x < 0 || x >= 3 || y < 0 || y >= 3 || board[x][y] == 1 || board[x][y] == 2) {
            System.out.println("Not a Legal move");
            return false;
        }
        return true;
    }
}

public class TicTicToeGame {
    public static void main(String[] args) {
        Board board = new Board();
        Random rand = new Random();
        board.displayBoard();
        while (!board.isGameOver()) {
            int x, y;
            do {
                System.out.println("Please enter your chance");
                x = board.scan.nextInt();
                y = board.scan.nextInt();
            } while (!board.isLegalMove(x, y));
            board.placeMove(new Points(x,y), 2);
            if (board.isGameOver()) {
                break;
            }
            board.minimax(0, 1);
            board.placeMove(board.computersMove, 1);
            board.displayBoard();
        }
        if (board.hasXwon()) {
            System.out.println("You Lost");
        } else if (board.hasOwon()) {
            System.out.println("We won");
        } else {
            System.out.println("Match draw");
        }
    }
}
