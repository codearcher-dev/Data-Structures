package Array;

import java.util.Arrays;

public class RotateArray {
    public static void rotate(int[] arr){
        for(int i = arr.length - 1 ; i > 0 ; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
        }
    }

    static void swap(int[] arr , int a , int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void reverse(int[] arr, int min , int max){
        while(max >= min){
            swap(arr,min,max);
            min++;
            max--;
        }
    }

    static void rotateArr(int arr[], int d) {
        int n = arr.length;
        d = d % n;

        reverse(arr,0,d-1);
        reverse(arr,d,n-1);
        reverse(arr,0,n-1);
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        rotateArr(arr,3);
        System.out.println(Arrays.toString(arr));
    }
}
