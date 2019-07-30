package com.company.Players;
import com.company.BoardPieces.Board;
import com.company.BoardPieces.OPiece;
import com.company.BoardPieces.Piece;
import com.company.BoardPieces.XPiece;
import com.company.gameLogic.MoveValidator;
import com.company.gameLogic.GameProgress;

import java.util.Random;

public class AIPlayerHardMode extends Player {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public AIPlayerHardMode(Piece piece) {
        super(piece);
    }

    private Random random = new Random();

    @Override
    public int makeMove(Board board) {
        for (int i = 1; i <= 9; i++) {
            Board tempBoard = new Board(board);
            tempBoard.setField(i, getPiece());

            if (!MoveValidator.validate(tempBoard, i)) {
                continue;
            }
            if ((new GameProgress(tempBoard)).isPieceWon(getPiece())) {
                return i;
            }
        }
        Piece opponent;

        if (getPiece().getSymbol() == ANSI_BLUE + 'X' + ANSI_RESET) {
            opponent = new OPiece();
        } else {
            opponent = new XPiece();
        }

        for (int i = 1; i <= 9; i++) {
            Board tempBoard = new Board(board);

            if (!MoveValidator.validate(tempBoard, i)) {
                continue;
            }

            tempBoard.setField(i, opponent);
            if ((new GameProgress(tempBoard)).isPieceWon(opponent)) {
                return i;
            }
        }

        return random.nextInt(9) + 1;
    }


}