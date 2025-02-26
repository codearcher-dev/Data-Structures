// Q. find the number of numbers that have even no. of digits in an Array

import java.lang.reflect.Array;
import java.util.Arrays;

public class EvenNoOfDigits {
    public static void main(String[] args) {
        int[] arr = {23 , 432, 5 , 1242, 6546, 75357,345,22,1000 , 32123,452341, 6321, 575, 3243,1111, 23121,4556};
        System.out.println("Length of array : "+arr.length);
        int count = 0;
        for (int i = 0; i< arr.length;i++){
            String str = new String(String.valueOf(arr[i]));
            if(str.length()%2==0){
                count = count+1;
            }
        }
        System.out.println("No. of numbers having even no of digits : " + count);

    }
}
