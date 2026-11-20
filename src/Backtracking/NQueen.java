package Backtracking;

import java.util.ArrayList;

public class NQueen {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        int[][] board = new int[n][n];
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        placeQueen(board, 0, result);

        return result;
    }

    public boolean isSafe(int[][] board, int row, int col) {
        int n = board.length;

        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    private void placeQueen(int[][] board, int row, ArrayList<ArrayList<Integer>> result) {
        int n = board.length;
        if (row == n) {
            ArrayList<Integer> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 1) {
                        ans.add(j+1);
                    }
                }
            }
            result.add(ans);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isSafe(board, row, i)) {
                board[row][i] = 1;
                placeQueen(board, row + 1, result);
                board[row][i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        NQueen obj = new NQueen();

        System.out.println(obj.nQueen(4));
    }
}
