package sliding.window;

public class BinarySubArraysWithSum {

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;
        System.out.println(findBinarySubArraysWithSum(nums, goal));
    }

    private static int findBinarySubArraysWithSum(int[] nums, int goal) {
        int count = 0;
        for (int i=0; i< nums.length; i++) {
            int sum = 0;
            int right = i;
            while (sum <= goal && right < nums.length) {
                sum += nums[right];
                if (sum == goal) count++;
                right++;
            }
        }

        return count;
    }

}
