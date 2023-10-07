package strategies.gamewinningstrategies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import models.Board;
import models.Cell;
import models.Player;

public class OrderOneWinningStrategy implements GameWinningStrategies {
    List<HashMap<Character, Integer>> rowSymbolCount = new ArrayList<>();
    List<HashMap<Character, Integer>> colSymbolCount = new ArrayList<>();
    HashMap<Character, Integer> topLeftDiagonalSymbolCount = new HashMap<>();
    HashMap<Character, Integer> topRightDiagonalSymbolCount = new HashMap<>();

    public OrderOneWinningStrategy(int dimension) {
        for (int i = 0; i < dimension; i++) {
            rowSymbolCount.add(new HashMap<>());
            colSymbolCount.add(new HashMap<>());
        }
    }

    private boolean isCellOnTopLeftDiagonal(int row, int col) {
        return row == col;
    }

    private boolean isCellonTopRightDiagonal(int row, int col, int dimension) {
        return row + col == dimension - 1;
    }

    @Override
    public boolean checkWinner(Board board, Player lastMovePlayer, Cell moveCell) {
        char symbol = lastMovePlayer.getSymbol();
        int row = moveCell.getRow();
        int col = moveCell.getCol();
        int dimension = board.getBoard().size();

        if (!rowSymbolCount.get(row).containsKey(symbol)) {
            rowSymbolCount.get(row).put(symbol, 0);
        }

        rowSymbolCount.get(row).put(symbol, rowSymbolCount.get(row).get(symbol) + 1);

        if (!colSymbolCount.get(col).containsKey(symbol)) {
            colSymbolCount.get(col).put(symbol, 0);
        }

        colSymbolCount.get(col).put(symbol, colSymbolCount.get(col).get(symbol) + 1);

        if (colSymbolCount.get(col).get(symbol) == dimension || rowSymbolCount.get(row).get(symbol) == dimension) {
            return true;
        }

        if (isCellOnTopLeftDiagonal(row, col)) {
            if (!topLeftDiagonalSymbolCount.containsKey(symbol)) {
                topLeftDiagonalSymbolCount.put(symbol, 0);
            }
            topLeftDiagonalSymbolCount.put(symbol, topLeftDiagonalSymbolCount.get(symbol) + 1);
            if (topLeftDiagonalSymbolCount.get(symbol) == dimension) {
                return true;
            }
        }

        if (isCellonTopRightDiagonal(row, col, dimension)) {
            if (!topRightDiagonalSymbolCount.containsKey(symbol)) {
                topRightDiagonalSymbolCount.put(symbol, 0);
            }
            topRightDiagonalSymbolCount.put(symbol, topRightDiagonalSymbolCount.get(symbol) + 1);
            if (topRightDiagonalSymbolCount.get(symbol) == dimension) {
                return true;
            }
        }

        return false;

    }
}
