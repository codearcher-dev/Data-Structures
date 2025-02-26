import java.util.*;

class Solution {
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> list = new ArrayList<>();
//        if (nums.length < 3){
//            return list;
//        }
//        for (int i = 0 ; i < nums.length-2; i++) {
//            for (int j = i + 1; j < nums.length - 1; j++) {
//                for (int k = j + 1; k < nums.length; k++) {
//                    if (i == j || i == k || j == k) {
//                    } else if (nums[i] + nums[j] + nums[k] == 0) {
//                        int finalI = i;
//                        int finalK = k;
//                        int finalJ = j;
//                        list.add(new ArrayList<>() {{
//                            add(nums[finalI]);
//                            add(nums[finalJ]);
//                            add(nums[finalK]);
//                        }});
//                    }
//                }
//            }
//        }
//        Set<List<Integer>> setofList = new HashSet<>();
//        for (List<Integer> innerList : list){
//            List<Integer> sortedList = new ArrayList<>(innerList);
//            Collections.sort(sortedList);
//            setofList.add(sortedList);
//        }
//        List<List<Integer>> uniqueList = new ArrayList<>(setofList);
//        return uniqueList;
//    }

        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums.length < 3) {
                return result;
            }

            // Sort the array
            Arrays.sort(nums);

            for (int i = 0; i < nums.length - 2; i++) {
                // Skip duplicates
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                int left = i + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum == 0) {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                        // Skip duplicates
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        left++;
                        right--;
                    } else if (sum < 0) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            return result;
        }
    }

    public class Demo {

        public static void main(String[] args) {
            int[] arr = {0, 0, 0};
            Solution obj = new Solution();
            System.out.println(obj.threeSum(arr));
        }
    }