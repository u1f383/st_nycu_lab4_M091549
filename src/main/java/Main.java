import java.util.Scanner;
import Game.Game;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Welcome to Rock-Paper-Scissors game ===");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Player 1 choice (rock, paper or scissors):");
        String p1 = scanner.nextLine();
        Game.checkInput(p1);

        System.out.println("Enter Player 2 choice (rock, paper or scissors):");
        String p2 = scanner.nextLine();
        Game.checkInput(p2);

        int result = Game.judgeWinner(p1, p2);
        switch (result) {
            case -1:
                System.out.println("Draw!");
                break;
            case 0:
                System.out.println("Player 2 win!");
                break;
            case 1:
                System.out.println("Player 1 win!");
                break;
        }
    }
}
