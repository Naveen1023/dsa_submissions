class Solution {
    int dp[][];
    public int numDistinct(String s, String t) {
        dp = new int[s.length()][t.length()];

        for(int a[] : dp) Arrays.fill(a, -1);

        return solve(0, 0, s, t);
    }

    private int solve(int i, int j, String s, String t) {
        if(j == t.length()) return 1;
        else if(i == s.length()) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int count = 0;
        if(s.charAt(i) == t.charAt(j)) {
            count += solve(i+1, j+1, s, t);
        }

        count += solve(i+1, j, s, t);

        return dp[i][j] = count;
    }
}
/*
i,j

if match => choose, notChoose
if notMatch = notChoose

if i == m && j == n => return 1

return match + notMatch

*/