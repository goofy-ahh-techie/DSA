package sliding.window;

import java.util.Arrays;

/*
* Fixed-size Sliding Window problem:
* Compute averages of all contiguous sub-arrays of size K by maintaining a rolling window sum and sliding it in O(n) time.
* */

public class AverageOfSubArrays {

    public static void main(String[] args) {
        int[] values = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int k = 5;

        float[] subArrAverages = findAvgOfSubArrays(values, k);
        WindowResult[] subArraysData = findAvgOfSubArrWithData(values, k);
        System.out.println(Arrays.toString(subArrAverages));
        Arrays.stream(subArraysData).map(WindowResult::toString).forEach(System.out::println);
    }

    private static float[] findAvgOfSubArrays(int[] values, int k) {
        if (values == null || k > values.length) return new float[0];

        int n = values.length;
        float windowSum = 0;
        int startIndex = 0;

        for (int i=0; i<k; i++) {
            windowSum += values[i];
        }
        float windowAvg = windowSum / k;

        float[] subArrValues = new float[n-k+1];
        subArrValues[startIndex] = windowAvg;
        startIndex++;

        for (int i=k; i<n; i++){
            windowSum += values[i];
            windowSum -= values[i-k];
            windowAvg = windowSum / k;
            subArrValues[startIndex] = windowAvg;
            startIndex++;
        }

        return subArrValues;
    }

    private static WindowResult[] findAvgOfSubArrWithData(int[] values, int k) {
        if (values == null || k > values.length) return new WindowResult[0];

        int n = values.length;
        float windowSum = 0;
        int startIndex = 0;

        for (int i=0; i<k; i++) {
            windowSum += values[i];
        }
        float windowAvg = windowSum / k;

        WindowResult[] subArrValues = new WindowResult[n-k+1];
        subArrValues[startIndex] = new WindowResult(windowAvg, Arrays.copyOfRange(values, startIndex, k));
        startIndex++;

        for (int i=k; i<n; i++){
            windowSum += values[i];
            windowSum -= values[i-k];
            windowAvg = windowSum / k;
            subArrValues[startIndex] = new WindowResult(windowAvg, Arrays.copyOfRange(values, startIndex, i+1));
            startIndex++;
        }

        return subArrValues;
    }
}