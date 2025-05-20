package LLD.Chess;

public class Queen extends Piece {
    public Queen(boolean isWhite) { super(isWhite); }
    public boolean canMove(Board board, Cell from, Cell to) {
        // Simplified: any direction
        return true;
    }
    public String toString() { return isWhite() ? "WQ" : "BQ"; }
}
