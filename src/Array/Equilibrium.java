package Array;

public class Equilibrium {
    public int equilibriumPoint(long[] arr) {
        long sum1=0;
        long sum2=0;
            for (long i : arr){
                sum1 += i;
            }
            for (int i = 0 ; i<arr.length;i++){
                sum1 -= arr[i];
                if (sum1 == sum2){
                    return i;
                }
                sum2 += arr[i];
            }
        return -1;
    }

    int arrSum(int[] arr ){
        int sum = 0;
        for(int num : arr){
            sum += num;
        }
        return sum;
    }
    String equilibrium(int arr[]) {
        if(arr.length < 3) return Boolean.toString(false);
        int sum = arrSum(arr);
        int leftSum = 0;
        int rightSum = sum;

        for(int i = 1 ; i < arr.length - 1; i++){
            leftSum += arr[i-1];
            rightSum = sum - leftSum - arr[i];
            if(leftSum == rightSum){
                return Boolean.toString(true);
            }
        }
        return Boolean.toString(false);
    }

    public static void main(String[] args) {
        long[] arr = {1,3,5,2,2};
        Equilibrium obj = new Equilibrium();
        long result = obj.equilibriumPoint(arr);
        System.out.println(result);
    }
}
