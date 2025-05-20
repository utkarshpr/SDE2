package LLD.Ludo;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(List.of("Red", "Blue", "Green", "Yellow"));
        Scanner scanner = new Scanner(System.in);

        while (true) {
            game.playTurn();
            System.out.println("Press Enter for next turn...");
            scanner.nextLine();
        }
    }
}

