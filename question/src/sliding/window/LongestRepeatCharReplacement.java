package sliding.window;

import java.util.HashMap;
import java.util.Map;

/*
* Variable-size Sliding Window problem: maximize the length of a substring that can be turned into all the same character
* with at most K replacements by tracking char frequencies and keeping (windowLen - maxFreq) <= K.
* */

public class LongestRepeatCharReplacement {

    public static void main(String[] args) {
        String s = "ABBA";
        int k = 2;

        int longRepeatCharAfterRepl = longestRepeatedCharReplSize(s, k);
        System.out.println(longRepeatCharAfterRepl);
    }

    private static int longestRepeatedCharReplSize(String s, int k) {
        int left = 0, maxFreq = 0, res = 0;
        Map<Character, Integer> freq = new HashMap<>();

        for (int right = 0; right<s.length(); right++) {
            char c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0) + 1);

            maxFreq = Math.max(maxFreq, freq.get(c));

            while ((right - left + 1) - maxFreq > k) {
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar)-1);
                left++;
            }

            res = Math.max(res, right-left+1);
        }

        return res;
    }
}
