package DynamicProgramming;

import java.util.Arrays;

public class CountingBits {

    public int countOne(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
    public int[] countBits(int n) {
        int[] count = new int[n+1];
        for (int i = 0 ; i < count.length;i++){
            count[i] = countOne(i);
        }
        return count;
    }

    public int[] optimizedCountBit(int n){
        int[] ans = new int[n + 1];
        ans[0] = 0;
        for(int i = 1; i <= n; i++)
        {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        CountingBits obj = new CountingBits();
        int n = 3;
        System.out.println(Arrays.toString(obj.optimizedCountBit(n)));
    }
}
