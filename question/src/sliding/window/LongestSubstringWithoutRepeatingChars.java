package sliding.window;

/*
* Variable-size Sliding Window problem: find the longest substring without repeating
* characters by expanding the window and shrinking from the left when a duplicate appears (O(n) using a set/map).
* */

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChars {

    public static void main(String[] agrs) {
        String value = "abcabcbb";

        int longDistinctSize = sizeOfLongUniqueChar(value);
        String uniqueCharSubString = longestUniqueCharsSubString(value);
        System.out.println("Size: " + longDistinctSize + ", SubString: " + uniqueCharSubString);
    }

    private static int sizeOfLongUniqueChar(String value) {
        if (value == null || value.isEmpty()) return 0;
        int maxSize = 0;
        int left = 0;
        Set<Character> charsSet = new HashSet<>();

        for (int right=0; right<value.length(); right++) {
            char c = value.charAt(right);

            while (charsSet.contains(c)) {
                charsSet.remove(value.charAt(left));
                left++;
            }

            charsSet.add(c);
            maxSize = Math.max(maxSize, right-left + 1);
        }
        return maxSize;
    }

    private static String longestUniqueCharsSubString(String value) {
        if (value == null || value.isEmpty()) return "";
        int maxSize = 0;
        int left = 0;
        String result = value;
        Set<Character> charsSet = new HashSet<>();

        for (int right=0; right<value.length(); right++) {
            char c = value.charAt(right);

            while (charsSet.contains(c)) {
                charsSet.remove(value.charAt(left));
                left++;
            }

            charsSet.add(c);
            int currSize = right - left + 1;
            if (currSize > maxSize) {
                maxSize = currSize;
                result = value.substring(left, right+1);
            }
        }
        return result;
    }
}
