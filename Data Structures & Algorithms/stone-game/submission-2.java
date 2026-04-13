class Solution {
    int dp[][];
    public boolean stoneGame(int[] piles) {
        dp = new int[piles.length][piles.length];

        for(int a[] : dp) Arrays.fill(a, -1);

        int totalScore = 0;
        for(int ele : piles) totalScore += ele;

        int aliceScore = findAliceMaxScore(0, piles.length-1, piles);

        return aliceScore > totalScore - aliceScore;
    }

    private int findAliceMaxScore(int first, int last, int arr[]) {

        if(first > last) return 0;

        // System.out.println("first : "+first+", last :"+last+", aliceScore : "+aliceScore+", turn : "+turn);
        int score = 0;

        if(dp[first][last] != -1) return dp[first][last];

        boolean isAliceTurn =  ((last-first+1) % 2 == 0) ? true : false;
        
        if(isAliceTurn) {
            score = Math.max(arr[first] + findAliceMaxScore(first+1, last, arr), arr[last] + findAliceMaxScore(first, last-1, arr));
        }
        else {
            score = Math.max(0 + findAliceMaxScore(first+1, last, arr), 0 + findAliceMaxScore(first, last-1, arr));
        }

        return dp[first][last] = score;
    }
}
/**


 */