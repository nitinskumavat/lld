package models;

import java.util.Scanner;

public class Player {
    private String name;
    private char symbol;
    private PlayerType type;

    public Player(String name, char symbol, PlayerType playerType) {
        this.name = name;
        this.symbol = symbol;
        this.type = playerType;
    }

    public String getName() {
        return this.name;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public PlayerType getType() {
        return this.type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void setType(PlayerType type) {
        this.type = type;
    }

    public Move decideMove(Board board) {
        boolean isValidMove = false;
        Move move = null;
        Scanner sc = new Scanner(System.in);
        while (!isValidMove) {
            System.out.println("Enter row number starting from 0:");
            int row = sc.nextInt();
            System.out.println("Enter column number starting from 0:");
            int col = sc.nextInt();
            isValidMove = board.isValidMove(row, col);
            if (!isValidMove) {
                System.out.println("Invalid move. Please try again.");
            }
            move = new Move(this, new Cell(row, col));
        }
        // sc.close();
        return move;
    }

}
