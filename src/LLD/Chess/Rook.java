package LLD.Chess;

public class Rook extends Piece {
    public Rook(boolean isWhite) {
        super(isWhite);
    }

    public boolean canMove(Board board, Cell from, Cell to) {
        if (from.getX() != to.getX() && from.getY() != to.getY()) {
            return false;
        }
        // No path-blocking check for simplicity
        return to.getPiece() == null || to.getPiece().isWhite() != this.isWhite();
    }

    public String toString() {
        return isWhite() ? "WR" : "BR";
    }
}

