package LLD.Ludo;

import java.util.*;

public class Cell {
    private int position;
    private boolean isSafeZone;
    private List<Token> tokens;

    public Cell(int position, boolean isSafeZone) {
        this.position = position;
        this.isSafeZone = isSafeZone;
        this.tokens = new ArrayList<>();
    }

    public int getPosition() { return position; }

    public boolean isSafeZone() { return isSafeZone; }

    public List<Token> getTokens() { return tokens; }

    public void addToken(Token token) {
        tokens.add(token);
    }

    public void removeToken(Token token) {
        tokens.remove(token);
    }
}
