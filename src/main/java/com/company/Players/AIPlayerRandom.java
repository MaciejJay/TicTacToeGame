package com.company.Players;

import com.company.BoardPieces.Board;
import com.company.BoardPieces.Piece;

import java.util.Random;

public class AIPlayerRandom extends Player {

    private Random random = new Random();

    public AIPlayerRandom(Piece piece) {
        super(piece);
    }

    @Override
    public int makeMove(Board board) {
        return random.nextInt(9) + 1;
    }
}
