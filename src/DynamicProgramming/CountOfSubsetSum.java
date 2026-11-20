package DynamicProgramming;

import java.util.Arrays;

public class CountOfSubsetSum {

    public int countSubset(int[] arr, int sum, int n) {       //Dynamic programming
        int[][] dp = new int[n + 1][sum + 1];

        for (int[] num : dp) {
            Arrays.fill(num, -1);
        }
        return countSubset(arr, sum, n, dp);
    }

    private int countSubset(int[] arr, int sum, int n, int[][] dp) {
        if (sum == 0 && n == 0) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }

        if (dp[n][sum] != -1) {
            return dp[n][sum];
        }
        if (arr[n - 1] > sum) {
            dp[n][sum] = countSubset(arr, sum, n - 1, dp);
            return dp[n][sum];
        }
        dp[n][sum] = countSubset(arr, sum - arr[n - 1], n - 1, dp) + countSubset(arr, sum, n - 1, dp);
        return dp[n][sum];
    }

    public int RecursiveCountSubset(int[] arr, int sum, int n) {     //Recursive Approach
        if (sum == 0 && n == 0) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        if (arr[n - 1] > sum) {
            return countSubset(arr, sum, n - 1);
        }
        return countSubset(arr, sum - arr[n - 1], n - 1) + countSubset(arr, sum, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 8, 10};
        int sum = 10;
        CountOfSubsetSum obj = new CountOfSubsetSum();

        System.out.println(obj.countSubset(arr, sum, arr.length));
    }
}
