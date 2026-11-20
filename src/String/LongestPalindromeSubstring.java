package String;

public class LongestPalindromeSubstring {
    public String longestPalindrome(String s) {
        // Handle edge cases where the string is null or has fewer than 2 characters.
        if (s == null || s.length() < 1) {
            return "";
        }

        // 'start' and 'end' will store the boundaries of the longest palindrome found.
        int start = 0;
        int end = 0;

        // Iterate through each character of the string to treat it as a potential center.
        for (int i = 0; i < s.length(); i++) {
            // Case 1: Find the longest odd-length palindrome with center at i.
            // Example: "racecar" centered at 'e'.
            int len1 = expandFromCenter(s, i, i);

            // Case 2: Find the longest even-length palindrome with center between i and i+1.
            // Example: "noon" centered between the two 'o's.
            int len2 = expandFromCenter(s, i, i + 1);

            // The longest palindrome centered at i is the max of the two cases.
            int len = Math.max(len1, len2);

            // If we found a new longest palindrome, update our 'start' and 'end' pointers.
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        // Return the longest palindrome substring using the final start and end indices.
        return s.substring(start, end + 1);
    }

    /**
     * Helper function to expand from a center and find the length of the palindrome.
     *
     * @param s     The input string.
     * @param left  The left pointer for the center.
     * @param right The right pointer for the center.
     * @return The length of the palindrome found.
     */
    private int expandFromCenter(String s, int left, int right) {
        // Expand outwards as long as the pointers are within bounds and the characters match.
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // The length of the palindrome is the distance between the final pointers.
        // Example: If s="bab", left starts at 1, right at 1. Loop expands left to 0, right to 2.
        // Loop expands again, left becomes -1, right becomes 3. Loop terminates.
        // The length is right - left - 1 = 3 - (-1) - 1 = 3.
        return right - left - 1;
    }

    public static void main(String[] args) {
        String str = "babad";
        LongestPalindromeSubstring obj = new LongestPalindromeSubstring();

        System.out.println(obj.longestPalindrome(str));
    }
}
