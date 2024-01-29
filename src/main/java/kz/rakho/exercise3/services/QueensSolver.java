package kz.rakho.exercise3.services;

import java.util.ArrayList;
import java.util.List;

public class QueensSolver {

    public static boolean isValid(int row, int col, int[] board) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || board[i] - i == col - row || board[i] + i == col + row) {
                return false;
            }
        }
        return true;
    }

    public static void solve(int size, int row, int[] board, List<int[]> results) {
        if (row == size) {
            results.add(board.clone());
            return;
        }
        for (int col = 0; col < size; col++) {
            if (isValid(row, col, board)) {
                board[row] = col;
                solve(size, row + 1, board, results);
                board[row] = -1;
            }
        }
    }

    public static List<int[]> findAllSolutions(int size) {
        List<int[]> results = new ArrayList<>();
        int[] board = new int[size];
        solve(size, 0, board, results);
        return results;
    }

}