package com.fredrik.ticTacToe.Game;

import java.util.Objects;
import java.util.Scanner;

public class Board {

    Scanner scanner = new Scanner(System.in);

    private String[][] boardState = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};

    private boolean[][] boardAvailability = {{true, true, true}, {true, true, true}, {true, true, true}};

    public boolean choseSquare(String playerShape) {

        int x;
        int y;

        String coordinates;

        coordinates = scanner.next();

        switch (coordinates) {
            case "1A" -> {x = 0; y = 0;}
            case "1B" -> {x = 0; y = 1;}
            case "1C" -> {x = 0; y = 2;}
            case "2A" -> {x = 1; y = 0;}
            case "2B" -> {x = 1; y = 1;}
            case "2C" -> {x = 1; y = 2;}
            case "3A" -> {x = 2; y = 0;}
            case "3B" -> {x = 2; y = 1;}
            case "3C" -> {x = 2; y = 2;}
            default -> {return true;}
        }

        if (boardAvailability[x][y]) {
            boardState[x][y] = playerShape;
            boardAvailability[x][y] = false;
        } else {
            return true;
        }
        return false;
    }

    public boolean checkBoardState(String shape) {

        int squaresInARow = 0;

        for (int i = 0; i < 3; i++) {
            squaresInARow = 0;
            for (int j = 0; j < 3; j++) {
                if (Objects.equals(boardState[i][j], shape)) {
                    squaresInARow++;
                } else squaresInARow = 0;
                if (squaresInARow == 3) {return true;}
            }
        }
        for (int i = 0; i < 3; i++) {
            squaresInARow = 0;
            for (int j = 0; j < 3; j++) {
                if (Objects.equals(boardState[j][i], shape)) {
                    squaresInARow++;
                } else squaresInARow = 0;
                if (squaresInARow == 3) {return true;}
            }
        }
        squaresInARow = 0;
        int i = 2;
        for (int j = 0; j < 3; j++) {
            if (Objects.equals(boardState[j][i], shape)) {
                squaresInARow++;
            } else squaresInARow = 0;
            if (squaresInARow == 3) {return true;}
            i--;
        }
        squaresInARow = 0;
        i = 0;
        for (int j = 0; j < 3; j++) {
            if (Objects.equals(boardState[i][j], shape)) {
                squaresInARow++;
            } else squaresInARow = 0;
            if (squaresInARow == 3) {return true;}
            i++;
        }
        return false;
    }

    public boolean boardFull() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (boardAvailability[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void displayBoard() {

        System.out.printf("\t A\t B\t C\n" +
                "1\t[%s]\t[%s]\t[%s]\n" +
                "2\t[%s]\t[%s]\t[%s]\n" +
                "3\t[%s]\t[%s]\t[%s]\n",
                boardState[0][0], boardState[0][1], boardState[0][2],
                boardState[1][0], boardState[1][1], boardState[1][2],
                boardState[2][0], boardState[2][1], boardState[2][2]
        );
    }
}
