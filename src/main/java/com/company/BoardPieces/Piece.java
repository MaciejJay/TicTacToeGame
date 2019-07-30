package com.company.BoardPieces;

public abstract class Piece {
    public abstract String getSymbol();

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Piece) {
            return ((Piece) obj).getSymbol() == this.getSymbol();
        }

        return super.equals(obj);
    }
}