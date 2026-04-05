class Solution {
    public int maxSubarraySumCircular(int[] arr) {
        int totalSum = 0;

        // for without wrapping one
        int maxSubarraySum = 0;
        int maxSum = 0;

        int minSubarraySum = 0;
        int minSum = 0;

        int largestElement = Integer.MIN_VALUE;


        for(int i=0;i<arr.length;i++) {
            totalSum += arr[i];
            largestElement = Math.max(largestElement, arr[i]);

            maxSum = Math.max(maxSum+arr[i], arr[i]);
            maxSubarraySum = Math.max(maxSubarraySum, maxSum);


            minSum = Math.min(arr[i], minSum+arr[i]);
            minSubarraySum = Math.min(minSubarraySum, minSum);
        }

        // System.out.println("totalSum : "+totalSum+", max : "+maxSubarraySum+", min :"+minSubarraySum);

        if(largestElement < 0) { // means all negative, just return this one
            return largestElement;
        }


        return Math.max(maxSubarraySum , totalSum-minSubarraySum);
    }
}
/*
2 cases : sum is not-wrapped , it's wrapped

for non-wrappign case : simple kadane's algo would work
no wrapping case : we can find out minimum subarary and subtract from the total sum.

*/