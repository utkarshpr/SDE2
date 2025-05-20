package LLD.Ludo;

import java.util.*;

public class Game {
    private List<Player> players;
    private Board board;
    private Dice dice;
    private int currentPlayerIndex = 0;

    public Game(List<String> playerNames) {
        players = new ArrayList<>();
        for (String name : playerNames) {
            players.add(new Player(name));
        }
        board = new Board();
        dice = new Dice();
    }

    public void playTurn() {
        Player player = players.get(currentPlayerIndex);
        System.out.println("\n" + player.getName() + "'s turn:");
        int roll = dice.roll();
        System.out.println("Rolled a " + roll);

        // Pick the first movable token for simplicity
        for (Token token : player.getTokens()) {
            if (canMove(token, roll)) {
                moveToken(token, roll);
                break;
            }
        }

        if (player.allTokensHome()) {
            System.out.println(player.getName() + " wins!");
            System.exit(0);
        }

        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    private boolean canMove(Token token, int steps) {
        if (token.isHome()) return false;
        if (token.isAtBase()) return steps == 6;
        return true;
    }

    private void moveToken(Token token, int steps) {
        if (token.isAtBase()) {
            token.setPosition(0);
            board.getCell(0).addToken(token);
            System.out.println("Token entered board at position 0.");
            return;
        }

        int oldPos = token.getPosition();
        int newPos = (oldPos + steps) % 52;

        Cell oldCell = board.getCell(oldPos);
        oldCell.removeToken(token);

        Cell newCell = board.getCell(newPos);
        List<Token> occupying = newCell.getTokens();

        // Kill if not safe zone
        if (!newCell.isSafeZone() && !occupying.isEmpty()) {
            for (Token t : new ArrayList<>(occupying)) {
                if (!t.getOwner().equals(token.getOwner())) {
                    t.setPosition(-1);
                    occupying.remove(t);
                    System.out.println("Captured a token!");
                }
            }
        }

        newCell.addToken(token);
        token.setPosition(newPos);
        System.out.println("Moved to position " + newPos);
    }
}

