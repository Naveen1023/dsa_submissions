class Solution {
    Boolean dp[][];
    public boolean canPartition(int[] arr) {
        
        int sum = 0;
        for(int ele : arr) {
            sum += ele;
        }
        int targetSum = 0;
        if(sum % 2 == 0) targetSum = sum/2;
        else return false;

        dp = new Boolean[arr.length][targetSum+1];
        return solve(0, arr, targetSum);
    }

    private boolean solve(int index, int arr[], int target) {
        if(index == arr.length) {
            if(target == 0) return true;
            return false;
        }

        if(dp[index][target] != null) return dp[index][target];
        if(arr[index] <= target) {
            if(solve(index+1, arr, target-arr[index])) return true;;
        }

        return dp[index][target] = solve(index+1, arr, target);
    }
}
