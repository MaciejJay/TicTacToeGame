package com.company.BoardPieces;

public class XPiece extends Piece {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";

    @Override
    public String getSymbol() {
        return ANSI_BLUE + 'X' + ANSI_RESET;
    }
}
