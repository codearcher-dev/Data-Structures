package Number;

public class ReverseNumber {
    public int reverse(int x) {
        boolean isNegative = (x < 0);
        if (isNegative) {
            x = x * (-1);
        }
        long reversedNum = 0;
        while (x > 0) {
            reversedNum = reversedNum * 10 + x % 10;
            x = x / 10;
        }
        if (isNegative) {
            reversedNum = reversedNum * (-1);
        }
        if (reversedNum > Integer.MAX_VALUE) return 0;
        return (int)reversedNum;
    }

    public static void main(String[] args) {
        ReverseNumber obj = new ReverseNumber();
        int num = 1534236469;

        System.out.println(obj.reverse(num));
    }
}
