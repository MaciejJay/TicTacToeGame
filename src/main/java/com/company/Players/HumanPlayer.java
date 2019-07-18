package com.company.Players;

import com.company.BoardPieces.Board;
import com.company.BoardPieces.Piece;

import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(Piece piece) {
        super(piece);
    }

    @Override
    public int makeMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
