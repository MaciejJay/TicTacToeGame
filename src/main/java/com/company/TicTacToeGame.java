package com.company;

import com.company.BoardPieces.Board;
import com.company.Menu.TicTacToeMenu;
import com.company.BoardPieces.OPiece;
import com.company.BoardPieces.XPiece;
import com.company.Players.*;
import com.company.GameLogic.GameProgress;
import com.company.GameLogic.MoveValidator;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeGame {
    private Board board = new Board(3, 3);
    private List<Player> players;
    private GameProgress gameProgress = new GameProgress(board);

    public void run() {
        TicTacToeMenu menu = new TicTacToeMenu();
        menu.printMenu();

        System.out.print("Choose game mode [1-4]: ");

        switch (menu.getAction()) {
            case TicTacToeMenu.EXIT:
                System.out.println("Goodbye!");
                break;
            case TicTacToeMenu.PLAY_WITH_AI:
                System.out.println();
                cleanBoard();
                preparePlayers(
                        new HumanPlayer(new XPiece()),
                        new AIPlayerHardMode(new OPiece())
                );
                start();
                break;
            case TicTacToeMenu.PLAY_WITH_RANDOMCOMPUTER:
                System.out.println();
                cleanBoard();
                preparePlayers(
                        new HumanPlayer(new XPiece()),
                        new AIPlayerRandom(new OPiece())
                );
                start();
                break;
            case TicTacToeMenu.PLAY_WITH_HUMAN:
                System.out.println();
                cleanBoard();
                preparePlayers(
                        new HumanPlayer(new XPiece()),
                        new HumanPlayer(new OPiece())
                );
                start();
                break;
        }
    }

    private void preparePlayers(Player A, Player B) {
        this.players = new ArrayList<>();
        players.add(A);
        players.add(B);
    }

    private void cleanBoard() {
        this.board = new Board(3, 3);
    }

    private void start() {
        int moveCounter = 0;
        while (!gameProgress.endGame()) {
            int playerNumber = moveCounter % 2;
            Player player = this.players.get(playerNumber);
            System.out.println("Player " + (playerNumber + 1) + ":");
            System.out.println();

            this.board.print();
            int move = player.makeMove(board);
            if (!MoveValidator.validate(board, move)) {
                System.out.println("Forbidden move");
                continue;
            }

            this.board.setField(move, player.getPiece());

            gameProgress.setBoard(this.board);
            moveCounter++;

        }

        this.board.print();
        System.out.println("The End");
        for (Player player : players) {
            if (gameProgress.isPieceWon(player.getPiece())) {
                System.out.println("Player " + player + " won!");
            }
        }
        if (moveCounter == 9) {
            System.out.println("Draw");
        }
    }
}