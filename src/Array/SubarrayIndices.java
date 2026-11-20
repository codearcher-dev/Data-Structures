package Array;

import java.util.ArrayList;
import java.util.Arrays;

public class SubarrayIndices {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i];

            if (sum == target) {
                indices.add(i + 1);
                indices.add(i + 1);
                return indices;
            }


            for (int j = i + 1; j < arr.length; j++) {
                sum += arr[j];
                if (sum == target) {
                    indices.add(i + 1);
                    indices.add(j + 1);
                    return indices;
                }
            }
        }
        indices.add(-1);
        return indices;
    }

    static ArrayList<Integer> subarraySum2(int[] arr, int target) {         //Sliding window approach
        int sum = 0;
        int start = 0;

        for (int end = 0; end < arr.length; end++) {
            sum += arr[end];

            while (sum > target && start < end){
                sum -= arr[start];
                start++;
            }

            if(sum == target){
                return new ArrayList<>(Arrays.asList(start+1 , end+1));
            }
        }
        return new ArrayList<>(Arrays.asList(-1));
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 7, 5};
        int target = 12;
        System.out.println(subarraySum2(arr, target));
        ;
    }
}
