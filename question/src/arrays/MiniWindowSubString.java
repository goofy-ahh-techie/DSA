package arrays;

import java.util.HashMap;
import java.util.Map;

public class MiniWindowSubString {

    public static void main(String[] args) {
        String s = "AAABBC";
        String t = "AABC";

        String result = findMiniWindowString(s, t);
        System.out.println(result);
    }

    private static String findMiniWindowString(String mainString, String subString) {
        Map<Character, Integer> target = new HashMap<>();
        for (Character c : subString.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }

        int formed = 0, required = target.size(), left = 0, start = 0;
        int minLen = Integer.MAX_VALUE;
        Map<Character, Integer> window = new HashMap<>();
        for (int right = 0; right < mainString.length(); right++) {
            char c = mainString.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (target.containsKey(c) && window.get(c).intValue() == target.get(c).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {

                int len = right - left + 1;
                if (minLen > len) {
                    minLen = len;
                    start = left;
                }

                char leftChar = mainString.charAt(left);
                window.put(leftChar, window.getOrDefault(leftChar, 0) - 1);

                if (target.containsKey(leftChar) && window.get(leftChar) < target.get(leftChar)) {
                    formed--;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : mainString.substring(start, start + minLen);
    }


//        int minLen = Integer.MAX_VALUE;
//        for (int i=0; i<s.length(); i++) {
//            Map<Character, Integer> window = new HashMap<>();
//
//            for (int j=i; j<s.length(); j++) {
//                char c = s.charAt(j);
//                window.put(c, window.getOrDefault(c, 0) + 1);
//
//                if (toCompare(window, target)) {
//                    int len = j-i+1;
//                    if (len < minLen) {
//                        minLen = len;
//                        result = s.substring(i, j+1);
//                        System.out.println(result);
//                    }
//                    break;
//                }
//            }
//        }

//    private static boolean toCompare(Map<Character, Integer> window, Map<Character, Integer> target) {
//        for (Map.Entry<Character, Integer> e: target.entrySet()) {
//            if (window.getOrDefault(e.getKey(), 0) < e.getValue()) {
//                return false;
//            }
//        }
//        return true;
//    }
}
