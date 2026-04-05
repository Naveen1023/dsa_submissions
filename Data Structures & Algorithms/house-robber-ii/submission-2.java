class Solution {
    public int rob(int[] arr) {
        if(arr.length == 1) return arr[0];
        int dp[] = new int[arr.length];

        Arrays.fill(dp, -1);

        int takeFirst = solve(0,arr.length-2, arr, dp);

        Arrays.fill(dp, -1);

        int skipFirst = solve(1,arr.length-1,arr, dp);

        return Math.max(takeFirst, skipFirst);
    }

    int solve(int index, int last, int arr[], int dp[]) {
        if(index > last) {
            return 0;
        }

        if(dp[index] != -1) return dp[index];

        int choose = arr[index] + solve(index+2, last, arr, dp);

        int notChoose = solve(index+1, last, arr, dp);

        return dp[index] = Math.max(choose, notChoose);
    }
}
