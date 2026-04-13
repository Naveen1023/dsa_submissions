class Solution {
    int dp[][];
    public int findTargetSumWays(int[] arr, int target) {
        int totalSum = 0;
        for(int ele : arr) totalSum += ele;

        dp = new int[arr.length][2*totalSum+1];

        for(int a[] : dp) Arrays.fill(a, Integer.MIN_VALUE);

        return solve(0, arr, 0, target, totalSum);
    }

    private int solve(int index, int arr[], int currSum, int target, int totalSum) {

        if(index >= arr.length) {
            if(target == currSum) return 1;
            else return 0;
        }

        if(dp[index][totalSum + currSum] != Integer.MIN_VALUE) return dp[index][totalSum + currSum];

        int pos = solve(index+1, arr, currSum + arr[index], target, totalSum);
        int neg = solve(index+1, arr, currSum - arr[index], target, totalSum);

        return dp[index][totalSum + currSum] = (pos + neg);
    }
}
/*
-x, +x
*/
