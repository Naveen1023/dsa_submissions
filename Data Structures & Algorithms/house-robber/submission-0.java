class Solution {
    int dp[];
    public int rob(int[] arr) {
        dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return solve(0, arr);
    }

    private int solve(int index, int arr[]) {
        if(index >= arr.length) return 0;

        if(dp[index] != -1) return dp[index];

        int choose = arr[index] + solve(index+2, arr);
        int notChoose = solve(index+1, arr);

        return dp[index] = Math.max(choose, notChoose);
    }
}
