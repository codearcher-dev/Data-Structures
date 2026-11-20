package DynamicProgramming;
///Incomplete
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if(s.equals(p)) return true;
        return false;
    }

    public static void main(String[] args) {
        String s = "aa";
        String p = "a*";

        RegularExpressionMatching obj = new RegularExpressionMatching();
        System.out.println(obj.isMatch(s,p));
    }
}
