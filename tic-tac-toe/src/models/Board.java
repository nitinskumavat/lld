package models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<List<Cell>> board;
    int dimension;

    public Board(int dimension) {
        this.dimension = dimension;
        this.board = new ArrayList<>();
        for (int i = 0; i < dimension; i++) {
            board.add(new ArrayList<>());
            for (int j = 0; j < dimension; j++) {
                board.get(i).add(new Cell(i, j));
            }
        }
    }

    public boolean isValidMove(int row, int col) {
        if (row < 0 || row >= dimension || col < 0 || col >= dimension) {
            return false;
        }
        return board.get(row).get(col).getCellState().equals(CellState.EMPTY);
    }

    public void display() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (board.get(i).get(j).getCellState().equals(CellState.EMPTY)) {
                    System.out.print("| |");
                } else {
                    System.out.print("|" + board.get(i).get(j).getPlayer().getSymbol() + "|");
                }
            }
            System.out.println();
        }
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

}
