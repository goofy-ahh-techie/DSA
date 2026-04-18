package sliding.window;

/* Fixed-size Sliding Window problem: check if S2 contains any length-|S1| substring with the same character frequency as S1
    (i.e., a permutation/anagram) by sliding a window and comparing counts.
*/

public class PermutationInString {

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "abc";

        System.out.println(isDataInPermutation(s1, s2));
    }

    private static boolean isDataInPermutation(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int k = s1.length();

        int[] s1_counts = new int[26];
        int[] s2_counts = new int[26];

        for (int i=0; i<k; i++) {
            s1_counts[s1.charAt(i) -'a']++;
            s2_counts[s2.charAt(i) -'a']++;
        }

        if (matches(s1_counts, s2_counts)) return true;

        for (int right = k; right < s2.length(); right++) {
            s2_counts[s2.charAt(right) - 'a']++;
            s2_counts[s2.charAt(right - k) - 'a']--;
            if (matches(s1_counts, s2_counts)) return true;
        }

        return false;
    }

    private static boolean matches(int[] a1, int[] a2) {
        for (int i=0; i<26; i++) {
            if (a1[i] != a2[i]) return false;
        }
        return true;
    }

}
