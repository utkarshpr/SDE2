package LLD.Chess;

public class Knight extends Piece {
    public Knight(boolean isWhite) { super(isWhite); }
    public boolean canMove(Board board, Cell from, Cell to) {
        int dx = Math.abs(from.getX() - to.getX());
        int dy = Math.abs(from.getY() - to.getY());
        return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
    }
    public String toString() { return isWhite() ? "WN" : "BN"; }
}