package LLD.Chess;

public class Cell {
    private int x, y;
    private Piece piece;

    public Cell(int x, int y, Piece piece) {
        this.x = x;
        this.y = y;
        this.piece = piece;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public Piece getPiece() { return piece; }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}

