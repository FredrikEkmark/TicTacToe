package com.fredrik.ticTacToe.Game;



public class TicTacToe {

    Shape circle = new Shape("O");
    Shape cross = new Shape("X");
    Board board = new Board();
    String winner;
    boolean gameRunning = true;

    public void runGame() {

        boolean validChoice;

        do {

            do {
                board.displayBoard();
                validChoice = board.choseSquare(circle.playerShape);
            } while (validChoice);

            if (board.checkBoardState(circle.playerShape)){
                gameRunning = false;
                winner = "Circle";
                break;
            }

            if (board.boardFull()) {
                gameRunning = false;
                winner = "Tied";
                break;
            }

            do {
                board.displayBoard();
                validChoice = board.choseSquare(cross.playerShape);
            } while (validChoice);

            if (board.checkBoardState(cross.playerShape)){
                gameRunning = false;
                winner = "Cross";
                break;
            }

            if (board.boardFull()) {
                gameRunning = false;
                winner = "Tied";
            }
        } while (gameRunning);
        board.displayBoard();
        System.out.println("\nWinner is " + winner);
    }
}
