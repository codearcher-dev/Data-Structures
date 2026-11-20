package Array;

import java.lang.reflect.Array;
import java.util.*;

public class NextGreaterElement {
    //Brute force method       Time Complexity O(n²)
    static int[] nextLargerElement(int[] arr, int n) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    result[i] = arr[j];
                    j = n - 1;
                } else if (j == n - 1) {
                    result[i] = -1;
                }
            }
            if (i == n - 1) {
                result[i] = -1;
            }
        }
        return result;
    }

    // Stack Method (Optimal Solution)    Time complexity O(n)
    public static ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int i = arr.length - 1;
        while (i >= 0) {
            if (stack.isEmpty()) {
                result.addFirst(-1);
                stack.push(arr[i]);
                i--;
            }
            else if (stack.peek() > arr[i]) {
                result.addFirst(stack.peek());
                stack.push(arr[i]);
                i--;
            }
            else if (stack.peek() < arr[i]) {
                stack.pop();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {6, 8, 0, 1, 3};
//        int[] result = nextLargerElement(arr, arr.length);
        System.out.println(nextLargerElement(arr));
        ArrayList<Integer> list = new ArrayList<>(5);
        System.out.println(list);
    }
}

