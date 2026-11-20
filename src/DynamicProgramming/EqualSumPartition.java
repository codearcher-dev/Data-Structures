package DynamicProgramming;

public class EqualSumPartition {
    public static boolean isPartitionPossible(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        } else {
            return new SubsetSum().isSubset(arr, sum / 2);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,3,-1,5};
        System.out.println(isPartitionPossible(arr));
    }
}
