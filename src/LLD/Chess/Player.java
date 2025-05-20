package LLD.Chess;

public class Player {
    private boolean isWhite;
    private String name;

    public Player(boolean isWhite, String name) {
        this.isWhite = isWhite;
        this.name = name;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public String getName() {
        return name;
    }
}
