package game;

public class Game {
    // ... scissors rock paper scissors rock ... for % 3
    private static final int rock = 0;
    private static final int paper = 1;
    private static final int scissors = 2;

    public static boolean checkInput(String in) throws IllegalArgumentException {
        if (! (("rock".equals(in)) || ("paper".equals(in)) || ("scissors".equals(in))) ) {
            throw new IllegalArgumentException("Bad Choice!");
        }
        return true;
    }

    /**
     * @return -1 if draw
     *          0 if winner is B
     *          1 if winner is A
     */
    public static int judgeWinner(String A, String B) {
        int a = keymap(A), b = keymap(B);
        int n = (a+1) % 3;

        if (n == b) {
            return 0;
        } else if (a == b) {
            return -1;
        }

        return 1;
    }

    private static int keymap(String s) {
        if (s.equals("rock")) {
            return rock;
        } else if (s.equals("paper")) {
            return paper;
        } else {
            return scissors;
        }
    }
}