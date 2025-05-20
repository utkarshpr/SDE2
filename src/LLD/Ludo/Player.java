package LLD.Ludo;

import java.util.*;
public class Player {
    private String name;
    private List<Token> tokens;

    public Player(String name) {
        this.name = name;
        this.tokens = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            tokens.add(new Token(this));
        }
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public String getName() {
        return name;
    }

    public boolean allTokensHome() {
        return tokens.stream().allMatch(Token::isHome);
    }
}

