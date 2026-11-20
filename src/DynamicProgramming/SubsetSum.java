package DynamicProgramming;

import Generics.Conversion;

import java.util.Arrays;

public class SubsetSum {

    public static void printToString(boolean[][] arr){
        for (boolean[] elem : arr){
            System.out.println(Arrays.toString(elem));
        }
    }

    public boolean isSubset(int[] arr, int target) {
        boolean[][] t = new boolean[arr.length + 1][target + 1];

        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                if (i == 0) {
                    t[i][j] = false;
                }
                if (j == 0) {
                    t[i][j] = true;
                }
            }
        }

        for (int i = 1; i < arr.length + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                if(arr[i-1] <= j){
                     t[i][j] = t[i-1][(j-arr[i-1] < t[i].length ? j-arr[i-1] : j)] || t[i-1][j];
                    // (j-arr[i-1] < t[i].length ? j-arr[i-1] : j) is only to prevent ArrayOutOfBoundException for Equal sum Partition problem
                }
                else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        Conversion<Boolean> obj = new Conversion<>();
        obj.printToString(t);
        return t[arr.length][target];
    }

    public static void main(String[] args) {
        int[] num = {1, 3, 7, 8, 10};
        int target = 11;
        SubsetSum obj = new SubsetSum();
        boolean result = obj.isSubset(num, target);

        System.out.println(result);
    }
}
