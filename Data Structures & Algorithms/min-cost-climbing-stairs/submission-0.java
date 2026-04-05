class Solution {
    int dp[];
    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length];

        Arrays.fill(dp, -1);
        
        int first = solve(0, cost);
        int second = solve(1, cost);

        return Math.min(first,second);
    }

    private int solve(int index, int arr[]) {

        if(index >= arr.length) return 0;

        if(dp[index] != -1) return dp[index];
        int cost1 = arr[index] + solve(index+1, arr);
        int cost2 = arr[index] + solve(index+2, arr);

        return dp[index] = Math.min(cost1, cost2);
    }
}
