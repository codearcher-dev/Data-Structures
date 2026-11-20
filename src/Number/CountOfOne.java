package Number;

//Count of 1 in binary of n
public class CountOfOne {
    public int countOne(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        CountOfOne obj = new CountOfOne();
        int n = 1024;
        System.out.println(Integer.toBinaryString(n));
        System.out.println("Count of 1 : " + obj.countOne(n));
    }
}
