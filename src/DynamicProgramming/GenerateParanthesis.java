package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

    public List<String> generateParenthesis(int n) {
        return generateParenthesis(n, "", 0, 0);
    }

    private List<String> generateParenthesis(int n, String p, int open, int closed) {
        if(open < closed) return new ArrayList<>();
        if (open == n) {
            while (open - closed != 0) {
                p += ")";
                closed++;
            }
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> list1 = generateParenthesis(n, p + "(", open + 1, closed);
        List<String> list2 = generateParenthesis(n, p + ")", open, closed + 1);
        list1.addAll(list2);
        return list1;
    }

    //More Optimized Approach

    public List<String> generateParenthesis2(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private static void backtrack(List<String> result, StringBuilder current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current.toString());
            return;
        }

        if (open < max) {
            current.append('(');
            backtrack(result, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1);
        }

        if (close < open) {
            current.append(')');
            backtrack(result, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParanthesis obj = new GenerateParanthesis();

        System.out.println(obj.generateParenthesis2(3));
    }
}
