package String;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        // Return 0 if the string is null or empty.
        if (s == null || s.length() == 0) {
            return 0;
        }

        // A map to store the most recent index of each character.
        // Key: character, Value: index
        Map<Character, Integer> charIndexMap = new HashMap<>();

        int maxLength = 0;
        int left = 0; // The left pointer of our sliding window.

        // Iterate through the string with the right pointer.
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // Check if we have seen the currentChar before.
            if (charIndexMap.containsKey(currentChar)) {
                // If the character's last seen index is within our current window (>= left),
                // we must shrink the window by moving the left pointer.
                // We use Math.max to ensure the left pointer only moves forward.
                left = Math.max(left, charIndexMap.get(currentChar) + 1);
            }

            // Update the character's last seen index to the current position.
            charIndexMap.put(currentChar, right);

            // Update the maxLength by comparing it with the current window size.
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstring obj = new LongestSubstring();
        String str = "pwwkew";
        System.out.println(obj.lengthOfLongestSubstring(str));
    }
}
