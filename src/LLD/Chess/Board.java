package LLD.Chess;

public class Board {
    private Cell[][] cells;

    public Board() {
        cells = new Cell[8][8];
        initialize();
    }

    private void initialize() {
        // Initialize empty cells
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cells[i][j] = new Cell(i, j, null);
            }
        }

        // Place white pieces
        cells[0][0].setPiece(new Rook(true));
        cells[0][1].setPiece(new Knight(true));
        cells[0][2].setPiece(new Bishop(true));
        cells[0][3].setPiece(new Queen(true));
        cells[0][4].setPiece(new King(true));
        cells[0][5].setPiece(new Bishop(true));
        cells[0][6].setPiece(new Knight(true));
        cells[0][7].setPiece(new Rook(true));

        // Place white pawns
        for (int i = 0; i < 8; i++) {
            cells[1][i].setPiece(new Pawn(true));
        }

        // Place black pieces
        cells[7][0].setPiece(new Rook(false));
        cells[7][1].setPiece(new Knight(false));
        cells[7][2].setPiece(new Bishop(false));
        cells[7][3].setPiece(new Queen(false));
        cells[7][4].setPiece(new King(false));
        cells[7][5].setPiece(new Bishop(false));
        cells[7][6].setPiece(new Knight(false));
        cells[7][7].setPiece(new Rook(false));

        // Place black pawns
        for (int i = 0; i < 8; i++) {
            cells[6][i].setPiece(new Pawn(false));
        }
    }


    public Cell getCell(int x, int y) {
        return cells[x][y];
    }
}

