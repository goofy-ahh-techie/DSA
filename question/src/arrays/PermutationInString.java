package arrays;

import java.util.Arrays;

public class PermutationInString {

    public static void main(String[] args) {
        String s1 = "abo";
        String s2 = "eidbaooo";

        System.out.println(isDataInPermutation(s1, s2));
    }

    private static boolean isDataInPermutation(String s1, String s2) {
        int left = 0, expectedLength = s1.length(), currLen = 0;
        int[] need = new int[26];
        for (char c : s1.toCharArray()) {
            need[c - 'a']++;
        }



        return false;
    }

}
