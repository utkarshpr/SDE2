package LLD.Chess;

public class Bishop extends Piece {
    public Bishop(boolean isWhite) { super(isWhite); }
    public boolean canMove(Board board, Cell from, Cell to) {
        return Math.abs(from.getX() - to.getX()) == Math.abs(from.getY() - to.getY());
    }
    public String toString() { return isWhite() ? "WB" : "BB"; }
}
