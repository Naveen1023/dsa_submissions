class Solution {
    int dp[][];
    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2];

        for(int a[] : dp) Arrays.fill(a, -1);

        return solve(0, 1, prices);
    }

    private int solve(int index, int canBuy, int arr[]) {

        if(index >= arr.length) {
            return 0;
        }

        if(dp[index][canBuy] != -1) return dp[index][canBuy];

        int profit = 0;
        if(canBuy > 0) {
            profit = -arr[index] + solve(index+1, 0, arr);
        }
        else{ // sell the stock
            profit = arr[index] + solve(index+2, 1, arr);
        }

        profit = Math.max(profit, solve(index+1, canBuy, arr));

        return dp[index][canBuy] = profit;
    }
}
