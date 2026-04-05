class Solution {
    int dp[];
    public int climbStairs(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n);
    }

    private int solve(int target) {
        if(target == 1 || target == 0) return 1;

        if(dp[target] != -1) return dp[target];
        int count = 0;
        if(target >= 2) count += solve(target-2);
        if(target >= 1) count += solve(target-1);

        return dp[target] = count;
    }
}
