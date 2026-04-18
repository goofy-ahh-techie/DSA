package sliding.window;

/* Variable-size Sliding Window counting problem: count all sub-arrays with at most K distinct values
    by maintaining a frequency map, shrinking when distinctCount > K, and adding (right-left+1) per step.
*/

import java.util.HashMap;
import java.util.Map;

public class SubArrWithAtMostKDistinctChar {

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 1};
        int k = 1;

        int result = findMaxKDistinctCharSubArr(nums, k);
        System.out.println(result);
    }

    private static int findMaxKDistinctCharSubArr(int[] data, int k) {
        int result = 0;
        int left = 0;

        Map<Integer, Integer> count = new HashMap<>();

        for (int right = 0; right<data.length; right++) {
            count.put(data[right], count.getOrDefault(data[right], 0) + 1);

            while (count.size() > k) {
                int leftElem = data[left];
                count.put(leftElem, count.getOrDefault(leftElem, 0) - 1);
                if (count.get(leftElem) == 0) count.remove(leftElem);
                left++;
            }

            result += (right - left) + 1;
        }

        return result;
    }


//          BRUTE FORCE ONE
//    
//    private static int findMaxKDistinctCharSubArr(int[] data, int k) {
//        int result = 0;
//        for (int i=0; i<data.length; i++) {
//            int maxCount = 0;
//            Map<Integer, Integer> count = new HashMap<>();
//            for (int j=i; j<data.length; j++) {
//                if (count.containsKey(data[j]) || count.size() <= k) {
//                    count.put(data[j], count.getOrDefault(data[j], 0) + 1);
//                }
//                if (count.size() > k) {
//                    count = new HashMap<>();
//                    break;
//                }
//                int currentValuesCount = 0;
//                for (Map.Entry<Integer, Integer> e : count.entrySet()) {
//                    currentValuesCount += e.getValue();
//                }
//                maxCount = Math.max(maxCount, currentValuesCount);
//            }
//            result += maxCount;
//        }
//
//        return result;
//    }

}
