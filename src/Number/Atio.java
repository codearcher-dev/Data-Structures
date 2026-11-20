package Number;

public class Atio {
    public int myAtoi(String s) {
        s = s.trim();
        StringBuilder str = new StringBuilder();
        for (int i = 0 ; i < s.length() ; i++){

        }
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        String str = "0-1";
        Atio obj = new Atio();
        System.out.println(obj.myAtoi(str));
    }
}
