package LLD.Chess;

public class Move {
    private Player player;
    private Cell from;
    private Cell to;
    private Piece pieceMoved;
    private Piece pieceKilled;

    public Move(Player player, Cell from, Cell to) {
        this.player = player;
        this.from = from;
        this.to = to;
        this.pieceMoved = from.getPiece();
        this.pieceKilled = to.getPiece();
    }

    public Piece getMovedPiece() {
        return pieceMoved;
    }

    public Piece getKilledPiece() {
        return pieceKilled;
    }
}

