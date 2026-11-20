import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Demo {

    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(List.of(intervals[0][0], intervals[0][1])));
        int j = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < list.get(j).get(1)) {
                if (intervals[i][0] == list.get(j).get(0)) {
                    list.get(j).set(1,Math.max(intervals[i][1], list.get(j).get(1)));
                } else if (intervals[i][1] <= list.get(j).get(1)) {
                }
                else {
                    list.add(new ArrayList<>(List.of(intervals[i][0], intervals[i][1])));
                    j++;
                }
            } else {
                list.add(new ArrayList<>(List.of(intervals[i][0], intervals[i][1])));
                j++;
            }
        }

        System.out.println(list);

        return list.size();
    }

    public int numberOfSubstrings(String s) {
        int count = 0;
        int a = 0;

        int i = 0;
        int j = 2;
        int n = s.length();

        while (j < n) {
            String substring = s.substring(i, j + 1);
            if (substring.contains("a") && substring.contains("b") && substring.contains("c")) {
                count += n - j;
                i += 1;
                j = i + 2;
            } else {
                j++;
            }
            a++;
            System.out.println(a);
        }
        return count;
    }

    public static void main(String[] args) {
        Demo obj = new Demo();

        int arr[][] = new int[][]{{1,2},{1,4},{3,4}};
        System.out.println(obj.removeCoveredIntervals(arr));
    }

}