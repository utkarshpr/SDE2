package LLD.Ludo;

import java.util.*;

public class Board {
    private List<Cell> cells;

    public Board() {
        cells = new ArrayList<>();
        for (int i = 0; i < 52; i++) {
            // Mark a few safe zones
            boolean safe = (i % 13 == 0);
            cells.add(new Cell(i, safe));
        }
    }

    public Cell getCell(int position) {
        return cells.get(position % 52);
    }
}

