package Array;

import java.util.Arrays;
import java.util.HashMap;

public class RemoveDuplicate {
    public static int[] remove(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int value : arr){
            if (map.containsKey(value)){
                map.put(value,map.get(value)+1);
            }
            else {
                map.put(value,1);
            }
        }
        int[] array = new int[map.size()];
        int i = 0;
        for (int key : map.keySet()){
            array[i] =  key;
            i++;
        }
        return array;
    }

    //If Array is Sorted
    public int removeInPlace(int[] arr) {
        if(arr.length == 1) return arr.length;
        int slow = 0;

        for (int fast = 1; fast < arr.length; fast++) {
            if (arr[fast] != arr[slow]) {
                slow++;
                arr[slow] = arr[fast];
            }
        }

        return slow + 1;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,7,8,8,9,9,10};
        int[] result = remove(arr);
        System.out.println(Arrays.toString(result));
    }
}
