package main.java.com.personal.String;

/**
 * Created by riyaz on 9/8/15.
 */
public class RobotMovement {
    public static void main(String[] args) {
        String path = "GLRLG";
        if (isCircular(path))
            System.out.println("Given sequence of moves is circular");
        else
            System.out.println("Given sequence of moves is NOT circular");
    }

    private static boolean isCircular(String path) {
        char direction = 'N';
        int x = 0;
        int y = 0;
        int i = 0;
        int length = path.length();
        while(i < length) {
            if (path.charAt(i) == 'G') {
                switch (direction) {
                    case 'n':
                    case 'N':
                        ++y;
                        break;
                    case 's':
                    case 'S':
                        --y;
                        break;
                    case 'e':
                    case 'E':
                        ++x;
                        break;
                    case 'w':
                    case 'W':
                        --x;
                }
            } else if (path.charAt(i) == 'L') {
                switch (direction) {
                    case 'n':
                    case 'N':
                        direction = 'W';
                        break;
                    case 's':
                    case 'S':
                        direction = 'E';
                        break;
                    case 'e':
                    case 'E':
                        direction = 'N';
                        break;
                    case 'w':
                    case 'W':
                        direction = 'S';
                        break;
                }
            } else {
                if (path.charAt(i) == 'R') {
                    switch (direction) {
                        case 'n':
                        case 'N':
                            direction = 'E';
                            break;
                        case 's':
                        case 'S':
                            direction = 'W';
                            break;
                        case 'e':
                        case 'E':
                            direction = 'S';
                            break;
                        case 'w':
                        case 'W':
                            direction = 'N';
                            break;
                    }
                }
            }
            ++i;
        }
        if( x == 0 && y == 0)
            return true;
        return false;
    }
}
