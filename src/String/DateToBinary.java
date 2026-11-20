package String;

import java.util.Arrays;

public class DateToBinary {
    public String toBinary(String str) {
        String binary = "";
        int num = Integer.valueOf(str);
        while (num > 0) {
            binary = num % 2 + binary;
            num = num / 2;
        }
        return binary;
    }

    public String convertDateToBinary(String date) {
        StringBuilder binary = new StringBuilder("");
        String[] arr = date.split("-");
        for (int i = 0 ; i < arr.length ; i++){
            binary.append(toBinary(arr[i]));
            if (i != arr.length-1){
                binary = binary.append("-");
            }
        }
        return binary.toString();
    }

    public static void main(String[] args) {
        DateToBinary obj = new DateToBinary();
        String date = "2080-02-29";
        System.out.println(obj.convertDateToBinary(date));
    }
}
