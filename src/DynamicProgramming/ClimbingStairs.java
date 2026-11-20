package DynamicProgramming;

import java.util.Arrays;

public class ClimbingStairs {
    public int memo(int n) {
        int[] dp = new int[n + 1];
        return climbStairs(n, dp);
    }

    public int climbStairs(int n, int[] dp) {
        if(n < 0) return 0;
        if (dp[n] != 0) {
            return dp[n];
        }
        if (n == 0) return 1;
        dp[n] = climbStairs(n - 1, dp) + climbStairs(n - 2, dp);
        return dp[n];
    }


    public int climbStairs(int n) {
        if (n == 0 || n == 1) return 1;
        if (n < 0) return 0;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static void main(String[] args) {
        ClimbingStairs obj = new ClimbingStairs();
        long start = System.nanoTime();
        System.out.println(obj.memo(44)); //O/P - 1123903170
        long end = System.nanoTime();
        System.out.println(end - start);
    }
}
