package LLD.Ludo;

public class Token {
    private Player owner;
    private int position; // -1 means in base, 100+ means home

    public Token(Player owner) {
        this.owner = owner;
        this.position = -1;
    }

    public boolean isAtBase() {
        return position == -1;
    }

    public boolean isHome() {
        return position >= 100;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int newPos) {
        this.position = newPos;
    }

    public Player getOwner() {
        return owner;
    }
}

