class Solution {
    int dp[][];
    public int lastStoneWeightII(int[] stones) {
        int totalSum = 0;
        for(int ele : stones) totalSum += ele;

        int targetSum = totalSum/2;
        dp = new int[stones.length][totalSum + 1];
        for(int a[] : dp) Arrays.fill(a, -1);
        return solve(0, 0, targetSum, stones, totalSum);
    }

    private int solve(int index, int currSum, int target, int arr[], int total) {

        if(index == arr.length || currSum >= target) {
            return Math.abs(total - 2*currSum);
        }

        if(dp[index][currSum] != -1) return dp[index][currSum];
        int choose = solve(index+1,currSum+arr[index], target, arr, total);
        int notChoose = solve(index+1, currSum, target, arr, total);

        // System.out.println("i="+index+", currSum="+currSum+", choose="+choose+", notChoose="+notChoose);

        return dp[index][currSum] = Math.min(choose, notChoose);
    }
}
/*
[59,60,61] => [59, 1] => [58]
           => [60, 2] => []

recursion + memo : task is to divide the array in two subsets such that the diff between sum of those is minimal. 
                   that would happen if sum approximates to totalSum/2
                   Let's find out the subset, that has the above property.

*/