class Solution {
    int dp[][];
    public int maxCoins(int[] arr) {
        dp = new int[arr.length][arr.length];

        for(int a[]: dp) Arrays.fill(a, -1);

        return solve(0, arr.length-1, arr);
    }

    private int solve(int i, int j, int arr[]) {

        if(j < i) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        int cost = 0;
        int left = (i > 0) ? arr[i-1] : 1;
        int right = (j < arr.length-1) ? arr[j+1] : 1;
        for(int k=i;k<=j;k++) {
            int currCost = left * right * arr[k];

            currCost += solve(i,k-1,arr) + solve(k+1,j,arr);
            
            cost = Math.max(cost, currCost);
        }

        return dp[i][j] = cost;
    }
}

/*
i, j 

try for every element k ƒrom i to j inclusive

cost = cost(k) + solve(array(i,k-1)) + solve(array(k+1, j));

                these sub-problems should be independent => if k is considered popped first => they become dependent as 
                                                            they become neighbours.
                                                        => if k is the last balloon to be burst in the subarray => neighbours would be i-1, j+1

cost(k) ===> arr[k] + left + right
*/
