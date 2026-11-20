package DynamicProgramming;

public class PerfectSum {
    public int perfectSum(int[] nums, int target) {
        int totalSum = 0;
        int count = 0;

        for(int i = 0 ; i < nums.length ; i++){
            int sum = nums[i];
            if(sum == target){
                count++;
            }
            for(int j = i+1 ; j < nums.length ; j++){
                sum += nums[j];
                if(sum == target){
                    count++;
                    j = nums.length;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {5,2,3,10,6,8};
        int target = 10;
        System.out.println(new PerfectSum().perfectSum(arr,target));
    }
}
