package LLD.Chess;

public class Main {
    public static void main(String[] args) {
        Player white = new Player(true, "Alice");
        Player black = new Player(false, "Bob");

        Game game = new Game(white, black);

        // Sample move: white pawn from (1, 0) to (2, 0)
        game.makeMove(1, 0, 2, 0);

        // Sample move: black pawn from (6, 0) to (5, 0)
        game.makeMove(6, 0, 5, 0);
    }
}
