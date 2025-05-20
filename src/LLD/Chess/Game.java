package LLD.Chess;

public class Game {
    private Player whitePlayer;
    private Player blackPlayer;
    private Board board;
    private boolean whiteTurn;
    private boolean gameOver;

    public Game(Player white, Player black) {
        this.whitePlayer = white;
        this.blackPlayer = black;
        this.board = new Board();
        this.whiteTurn = true;
        this.gameOver = false;
    }

    public boolean makeMove(int startX, int startY, int endX, int endY) {
        if (gameOver) return false;

        Cell from = board.getCell(startX, startY);
        Cell to = board.getCell(endX, endY);

        Piece piece = from.getPiece();
        if (piece == null || piece.isWhite() != whiteTurn) {
            System.out.println("Invalid move: not your turn or empty cell.");
            return false;
        }

        if (!piece.canMove(board, from, to)) {
            System.out.println("Invalid move: can't move there.");
            return false;
        }

        to.setPiece(piece);
        from.setPiece(null);
        whiteTurn = !whiteTurn;

        System.out.println((whiteTurn ? "Black" : "White") + "'s turn");
        return true;
    }
}
