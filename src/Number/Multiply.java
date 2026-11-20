package Number;

public class Multiply {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        int n = num1.length();
        int m = num2.length();

        int[] arr = new int[m+n];

        for (int i = n -1 ; i >= 0 ; i--){
            for (int j = m - 1; j >= 0; j--){
                int mul = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = mul + arr[p2];
                arr[p2] = (sum % 10);
                arr[p1] += (sum / 10);
            }
        }
        StringBuilder ans = new StringBuilder();
        for(int x : arr){
            if(ans.length() == 0 && x == 0){
                continue;
            }
            ans.append(x);

        }
        return  ans.toString();
    }
}
