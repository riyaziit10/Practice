package main.java.com.personal.Random;

/**
 * Created by riyaz on 19/11/15.
 */

interface State {
    public State next(Input word);
}

class Input {
    private String input;
    private int current;

    public Input(String input) {
        this.input = input;
    }

    char read() {
        if(current >= input.length())
            return ' ';
        return input.charAt(current++);
    }
}

enum States implements State {

    Init {
        @Override
        public State next(Input word) {
            switch (word.read()) {
                case 'a':
                    return A;
                default:
                    return Fail;
            }
        }
    },

    A {
        @Override
        public State next(Input word) {
            switch (word.read()) {
                case 'a':
                    return A;
                case 'b':
                    return B;
                case 'c':
                    return C;
                default:
                    return Fail;
            }
        }
    },
    B {
        @Override
        public State next(Input word) {
            switch (word.read()) {
                case 'b':
                    return B;
                case 'c':
                    return C;
                default:
                    return Fail;
            }
        }
    },

    C {
        @Override
    public State next(Input word) {
            switch (word.read()) {
                case 'c': return C;
                case ' ': return null;
                default: return Fail;
            }
        }
    },

    Fail {
        @Override
        public State next(Input word) {
            return Fail;
        }
    };

}

public class FSM {

    public static void main(String[] args) {
        State s;
        Input in = new Input("abc");
        for( s = States.Init; s != null && s != States.Fail; s = s.next(in)) {
//            System.out.println(s);
        }
        if(s == null)
            System.out.println("valid");
        else
            System.out.println("Invalid");
    }
}
