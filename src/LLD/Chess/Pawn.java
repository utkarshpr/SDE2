package LLD.Chess;


public class Pawn extends Piece {
    public Pawn(boolean isWhite) { super(isWhite); }
    public boolean canMove(Board board, Cell from, Cell to) {
        int dir = isWhite() ? 1 : -1;
        return from.getY() == to.getY() && (to.getX() - from.getX()) == dir;
    }
    public String toString() { return isWhite() ? "WP" : "BP"; }
}