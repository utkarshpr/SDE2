package LLD.Chess;

public class King extends Piece {
    public King(boolean isWhite) { super(isWhite); }
    public boolean canMove(Board board, Cell from, Cell to) {
        // Simplified: King can move 1 square in any direction
        int dx = Math.abs(from.getX() - to.getX());
        int dy = Math.abs(from.getY() - to.getY());
        return (dx <= 1 && dy <= 1);
    }
    public String toString() { return isWhite() ? "WK" : "BK"; }
}