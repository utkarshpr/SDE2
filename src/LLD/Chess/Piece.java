package LLD.Chess;

public abstract class Piece {
    private boolean isWhite;
    private boolean isKilled;

    public Piece(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public boolean isKilled() {
        return isKilled;
    }

    public void setKilled(boolean killed) {
        this.isKilled = killed;
    }

    public abstract boolean canMove(Board board, Cell from, Cell to);
}

