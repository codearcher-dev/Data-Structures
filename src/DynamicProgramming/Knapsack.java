package DynamicProgramming;

import java.util.Arrays;

public class Knapsack {

    //Recursive method
    public int maxProfit(int[] weight, int[] profit, int w, int n) {        //without memoization
        if (n == 0 || w == 0) {
            return 0;
        }
        if (weight[n - 1] <= w) {
            return Math.max(profit[n - 1] + maxProfit(weight, profit, w - weight[n - 1], n - 1),
                    maxProfit(weight, profit, w, n - 1));
        } else {
            return maxProfit(weight, profit, w, n - 1);
        }
    }

    //Dynamic programming approach
    public int maxProfit(int[] weight, int[] profit, int w, int n, int[][] memo) {        //With Memoization
        if (n == 0 || w == 0) {
            return 0;
        }

        if (memo[w][n] != -1) {       //fetch result if exists
            return memo[w][n];
        }

        if (weight[n - 1] <= w) {
            return memo[w][n] = Math.max(profit[n - 1] + maxProfit(weight, profit, w - weight[n - 1], n - 1, memo),
                    maxProfit(weight, profit, w, n - 1, memo));
        } else {
            return memo[w][n] = maxProfit(weight, profit, w, n - 1, memo);
        }
    }

    //Top-down approach

    public int[][] knapsack(int[] weight, int[] profit, int w, int n) {
        int[][] matrix = new int[n + 1][w + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                if (i == 0 || j == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (weight[i - 1] <= j) {
                    matrix[i][j] = Math.max(profit[i - 1] + matrix[i - 1][j - weight[i - 1]], matrix[i - 1][j]);
                } else {
                    matrix[i][j] = matrix[i - 1][j];
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[] wt = {1, 3, 4, 5};
        int[] pft = {3, 5, 1, 7};
        int w = 6;

        int[][] memo = new int[w + 1][wt.length + 1];

        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        System.out.println(new Knapsack().maxProfit(wt, pft, w, wt.length, memo));
        System.out.println(Arrays.deepToString(new Knapsack().knapsack(wt, pft, w, wt.length)));

        for (int[] arr : memo) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
