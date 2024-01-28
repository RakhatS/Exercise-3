package kz.rakho.exercise3.controllers;


import java.util.ArrayList;
import kz.rakho.exercise3.models.QueenPosition;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/queens")
class QueensController {

    @PostMapping("/place")
    public QueenPosition[] placeQueens(@RequestBody QueenPosition queenPosition) {
        int n = 8;
        QueenPosition[] queens = new QueenPosition[8];
        ArrayList<int[]> queensPositions = solveNQueensGivenFirstQueen(queenPosition.getRow(), queenPosition.getCol(), n);

        for (int i = 0; i < queensPositions.get(0).length; i++) {
            QueenPosition qp = new QueenPosition(i + 1, (queensPositions.get(0)[i] + 1));
            queens[i] = qp;

        }
        return queens;
    }

    private boolean isSafe(int[] board, int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || board[i] - i == col - row || board[i] + i == col + row) {
                return false;
            }
        }
        return true;
    }

    private void solveNQueensUtil(int[] board, int row, int n, ArrayList<int[]> result) {
        if (row == n) {
            result.add(board.clone());
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row] = col;
                solveNQueensUtil(board, row + 1, n, result);
            }
        }
    }

    private ArrayList<int[]> solveNQueensGivenFirstQueen(int firstQueenRow, int firstQueenCol, int n) {
        int[] board = new int[n];
        board[firstQueenRow] = firstQueenCol;

        ArrayList<int[]> result = new ArrayList<>();
        solveNQueensUtil(board, firstQueenRow + 1, n, result);

        return result;
    }


}
