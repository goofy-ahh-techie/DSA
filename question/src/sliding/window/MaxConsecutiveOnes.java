package sliding.window;

/*
* Variable-size Sliding Window problem: find the longest sub-array with at most K zeros
* by expanding the window and shrinking from the left when zeroCount exceeds K.
* */

public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};;
        int flipsCount = 2;
        int maxOnesAfterFlip = findMaxNumOfOnesAfterFlip(nums, flipsCount);
        System.out.println(maxOnesAfterFlip);
    }

    private static int findMaxNumOfOnesAfterFlip(int[] nums, int flipsCount) {
        if (nums == null || nums.length == 0) return 0;

        int left = 0, maxOnes = 0, zerosCount = 0;

        for (int right=0; right<nums.length; right++) {
            if (nums[right] == 0) zerosCount++;

            while (zerosCount > flipsCount) {
                if (nums[left] == 0) {
                    zerosCount--;
                }
                left++;
            }

            maxOnes = Math.max(maxOnes, right - left + 1);
        }

        return maxOnes;
    }

}
