package arrays;

import java.util.Arrays;

/*
    Find the maximum sum of any contiguous sub-array of size K in O(n) time
*/

public class MaxSumOfSubArray {

    public static void main(String[] args) {
        int[] data = {-2, -1, -5, -1, -3};
        int k = 2;

        int maxSum = (int) findMaxSumOfSubArray(data, k).data;
        int[] maxSumArray = findMaxSumOfSubArray(data, k).subArray;
        System.out.println("Maximum Sum: " + maxSum + ", and this is the SubArray: " + Arrays.toString(maxSumArray));
    }

    private static WindowResult findMaxSumOfSubArray(int[] data, int k) {
        int n = data.length;
        int maxSum;
        int windowSum = 0;
        int startIndex = 0;

        for (int i=0; i<k; i++) {
            windowSum += data[i];
        }
        maxSum = windowSum;

        for (int i=k; i<n; i++) {
            windowSum += data[i];
            windowSum -= data[i-k];
            if (windowSum > maxSum) {
                maxSum = windowSum;
                startIndex = i-k + 1;
            }
        }

        int[] maxSumArray = Arrays.copyOfRange(data, startIndex, startIndex + k);
        return new WindowResult<>(maxSum, maxSumArray);
    }
}

class WindowResult<T> {
    T data;
    int[] subArray;

    public WindowResult(T sum, int[] subArray) {
        this.subArray = subArray;
        this.data = sum;
    }

    @Override
    public String toString() {
        return "Avg: " + data + ", SubArray: " + Arrays.toString(subArray);
    }
}
