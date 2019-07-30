package com.company.BoardPieces;

public class OPiece extends Piece {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    @Override
    public String getSymbol() {
        return ANSI_RED + 'O' + ANSI_RESET;
    }
}
