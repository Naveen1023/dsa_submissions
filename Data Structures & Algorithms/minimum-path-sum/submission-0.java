class Solution {
    int dp[][];
    public int minPathSum(int[][] arr) {
        dp = new int[arr.length][arr[0].length];

        for(int a[] : dp) Arrays.fill(a, 1000000);

        return solve(0, 0, arr);
    }

    private int solve(int i, int j, int arr[][]) {

        if(i == arr.length-1 && j == arr[0].length-1) return arr[i][j];

        int downSum = 1000000;
        int rightSum = 1000000;


        if(dp[i][j] != 1000000) return dp[i][j];
        // down
        if(i+1 < arr.length) {
           downSum = arr[i][j] + solve(i+1, j, arr); 
        }
        // right
        if(j+1 < arr[0].length) {
           rightSum = arr[i][j] + solve(i, j+1, arr); 
        }

        return dp[i][j] = Math.min(downSum, rightSum);
    }
}