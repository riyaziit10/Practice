package main.java.com.personal.Company;

import java.util.*;

class User {
    int id;
    int currentPosition = 0;

    public User(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}

class SnakeAndLadder {
    int arr[];
    int snakePointers[][] = null;
    int ladderPointers[][] = null;
    int snakePointersSize = 0;
    int laddersPointersSize = 0;
    int currentUSerIndex = 0;
    Map<String, User> userList = new HashMap<String, User>();
    boolean multiUSer = false;

    public void createSingleUser() {
        userList.clear();
        int id = 1;
        User user = new User(id);
        userList.put("user" + id, user);
        System.out.println("User" + id + "created successfully");
    }

    public void createMultipleUser() {
        userList.clear();
        multiUSer = true;
        for (int i = 0; i < 2; ++i) {
            userList.put("user" + i, new User(i));
            System.out.println("User" + i + "created successfully");
        }
    }

    public int rollDice() {
        Random random = new Random();
        int dice = random.nextInt(6);
        System.out.println("Dice Value is .." + dice);
        return dice;
    }

    public Map<String, String> getProperties() {
        Map<String, String> prop = new HashMap<String, String>();
        prop.put("snake.pointers.total", "4");
        prop.put("snake.pointers.1", "98,21");
        prop.put("snake.pointers.2", "72,34");
        prop.put("snake.pointers.3", "57,25");
        prop.put("snake.pointers.4", "49,17");
        prop.put("ladder.pointers.total", "4");
        prop.put("ladder.pointers.1", "11,28");
        prop.put("ladder.pointers.2", "36,62");
        prop.put("ladder.pointers.3", "24,49");
        prop.put("ladder.pointers.4", "51,87");
        return prop;
    }

    public SnakeAndLadder() {
        this.arr = new int[100];
        for (int i = 0; i < 100; ++i)
            arr[i] = i + 1;
        Map<String, String> prop = getProperties();
        snakePointersSize = Integer.parseInt(prop.get("snake.pointers.total"));
        laddersPointersSize = Integer.parseInt(prop.get("ladder.pointers.total"));
        snakePointers = new int[snakePointersSize][2];
        ladderPointers = new int[laddersPointersSize][2];
        for (int i = 0; i < snakePointersSize; ++i) {
            String a[] = prop.get("snake.pointers." + (i + 1)).split(",");
            snakePointers[i][0] = Integer.parseInt(a[0]);
            snakePointers[i][1] = Integer.parseInt(a[1]);
        }
        for (int i = 0; i < laddersPointersSize; ++i) {
            String a[] = prop.get("ladder.pointers." + (i + 1)).split(",");
            ladderPointers[i][0] = Integer.parseInt(a[0]);
            ladderPointers[i][1] = Integer.parseInt(a[1]);
        }
    }

    public void displaySLPointers() {
        System.out.println("Snake and ladder pointers");
        for (int i = 0; i < snakePointersSize; ++i) {
            System.out.println("snake in\t" + snakePointers[i][0] + "----->>>" + snakePointers[i][1]);
        }
        for (int i = 0; i < laddersPointersSize; ++i) {
            System.out.println("Ladders in \t" + ladderPointers[i][0] + "============" + ladderPointers[i][1]);
        }
    }

    public void displayUserPosition() {
        Set keySet = userList.keySet();
        Iterator it = keySet.iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            User user = userList.get(key);
            System.out.println("UserPosition\t" + user.getCurrentPosition());
        }
    }

    public void displayBoard() {
        for (int i = 100; i > 0; ) {
            int end = i - 10;
            while (i > end) {
                System.out.print(arr[i - 1] + "\t");
                --i;
            }
            System.out.println();
            int k = i - 10;
            while (k < i) {
                System.out.print(arr[k] + "\t");
                ++k;
            }
            i = i - 10;
            System.out.println();
        }
        displaySLPointers();
    }

    public int updateUserPosition(String username) {

        if (userList.containsKey(username)) {
            User user = userList.get(username);
            user.setCurrentPosition(user.getCurrentPosition() + rollDice());
            return user.getCurrentPosition();
        }
        return 0;
    }

    public int checkSLPointersForCurPos(int position) {
        for (int i = 0; i < snakePointersSize; ++i) {
            if (snakePointers[i][0] == position) {
                System.out.println("Snake byte you");
                return snakePointers[i][1];
            }
        }
        for (int i = 0; i < laddersPointersSize; ++i) {
            if (ladderPointers[i][0] == position) {
                System.out.println("Wow! you have climb up the the ladder");
                return ladderPointers[i][1];
            }
        }

        return position;
    }

    public String getCurrentUsername() {
        if (currentUSerIndex == 0) {
            currentUSerIndex++;
            return "user" + currentUSerIndex;
        } else if (currentUSerIndex == 1) {
            if (multiUSer == true) {
                currentUSerIndex++;
                return "user" + currentUSerIndex;
            } else {
                return "user" + currentUSerIndex;
            }
        } else {
            currentUSerIndex--;
            return "user" + currentUSerIndex;
        }
    }

    public void playGame() {
        int i = 0;
        System.out.println("Game Started ...");
        do {
            String curName = getCurrentUsername();
            System.out.println("1.Roll dice\n 2.Show Positions\n 3.DisplayBoard\n 4.Stop Game\n");
            System.out.println("Chance for user\t" + curName);
            System.out.println("Please provide your input");
            Scanner scanner = new Scanner(System.in);
            i = scanner.nextInt();
            switch (i) {
                case 1:
                    int curPos = this.updateUserPosition(curName);
                    if (curPos >= 100) {
                        System.out.println("Your have successfully won the game Exiting");
                        return;
                    }
                    break;
                case 2:
                    this.displayUserPosition();
                    if (multiUSer == true) {
                        currentUSerIndex = currentUSerIndex == 2 ? 1 : 0;
                    }
                    break;
                case 3:
                    this.displayBoard();
                    if (multiUSer == true) {
                        currentUSerIndex = currentUSerIndex == 2 ? 1 : 0;
                    }
                    break;
                case 4:
                    return;
            }
        } while (i != 0);
    }

}

public class SnakeAndLadderGame {
    public static void main(String[] args) {
        SnakeAndLadder sl = new SnakeAndLadder();
        System.out.println("Snake and ladder Game User options");
        System.out.println("1.Start the game\n 2. Single player\n 3.MultiPlayer \n 4.Exit Game");
        System.out.println("Please provide your options");
        int i = 1;
        while(i != 0) {
            Scanner scan = new Scanner(System.in);
            i = scan.nextInt();
            switch (i) {
                case 1:
                    if(sl.userList.size() == 0) {
                        System.out.println("Please create user and play the game");
                        break;
                    }else {
                        sl.playGame();
                    }
                    break;
                case 2:
                    sl.createSingleUser();
                    break;
                case 3:
                    sl.createMultipleUser();
                    break;
                case 4:
                    System.exit(0);
            }
            System.out.println();
            System.out.println("Snake & Ladder Game \n Select User Options");
            System.out.println("1. Start Game \n2. "
                    + "Sinlge Player \n3. Multi Players(only 2) \n4. Exit Game");
            System.out.print("Please provide your option : ");
        }
    }
}
