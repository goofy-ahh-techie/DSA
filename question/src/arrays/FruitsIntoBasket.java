package arrays;

import java.util.HashMap;
import java.util.Map;

/*
 * Variable-size Sliding Window problem: find the longest contiguous sub-array containing
 * at most 2 distinct fruit types by tracking counts in a map and shrinking when distinct types exceed 2.
 * */

public class FruitsIntoBasket {

    public static void main(String[] args) {
        int[] fruits = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};

        int maxFruits = findMaxFruitsInBaskets(fruits);
        System.out.println(maxFruits);
    }

    private static int findMaxFruitsInBaskets(int[] fruits) {
        if (fruits == null || fruits.length == 0) return 0;

        Map<Integer, Integer> fruitsCount = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < fruits.length; right++) {
            fruitsCount.put(fruits[right], fruitsCount.getOrDefault(fruits[right], 0) + 1);
            while (fruitsCount.size() > 2) {
                int leftValue = fruits[left];
                fruitsCount.put(fruits[left], fruitsCount.get(fruits[left]) - 1);
                left++;

                if (fruitsCount.get(leftValue) == 0) fruitsCount.remove(leftValue);
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }


}
