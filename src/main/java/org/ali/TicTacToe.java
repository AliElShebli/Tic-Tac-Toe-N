package org.ali;

import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (!board.isFull()) {
            System.out.println("Player " + currentPlayer.getMarker() + ", enter your move (row and column): ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (board.isCellEmpty(x, y)) {
                board.place(x, y, currentPlayer.getMarker());
                switchCurrentPlayer();
            } else {
                System.out.println("Cell is not empty! Try again.");
            }
        }
    }

    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.start();
    }
}
