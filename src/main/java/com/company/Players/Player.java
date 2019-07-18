package com.company.Players;

import com.company.BoardPieces.Board;
import com.company.BoardPieces.Piece;

public abstract class Player {
    private Piece piece;

    public Player(Piece piece) {
        this.piece = piece;
    }

    public abstract int makeMove(Board board);

    public Piece getPiece() {
        return piece;
    }

    @Override
    public String toString() {
        return String.valueOf(this.piece.getSymbol());
    }
}
