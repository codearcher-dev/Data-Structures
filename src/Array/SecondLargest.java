package Array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.*;
import java.util.List;

public class SecondLargest {
    public int print2largest(List<Integer> arr) {
        int Maxindex = arr.size() - 1 ;
        int result = -1;
        if(arr.size() > 1) {
            Collections.sort(arr);
            Collections.reverse(arr);
            for(int i = 0 ; i < Maxindex ; i++){
                if(arr.get(i) > arr.get(i+1)){
                    result = arr.get(i + 1);
                    break;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(10,10,10);
        System.out.println(arr);
        SecondLargest obj = new SecondLargest();
        int result  = obj.print2largest(arr);
        System.out.println(result);
     }
}
