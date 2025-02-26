import java.util.Arrays;
import java.util.Scanner;

public class LinearSearch {
    public int Search(int[] arr , int item){
        for(int i = 0 ; i < arr.length; i++){
            if (arr[i] == item){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinearSearch obj = new LinearSearch();
        System.out.print("Enter the size of array : ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.print("\nEnter the elements of array : ");
        for (int i = 0 ; i < size ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Array elements are : " + Arrays.toString(arr));
        System.out.print("\nEnter the Target item : ");
        int item = sc.nextInt();
        int result = obj.Search(arr , item);
        if(result != -1){
            System.out.println("Item is found at index :  "+ result);
        }
        else {
            System.out.println("Item not found.");
        }
    }
}
