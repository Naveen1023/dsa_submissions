class Solution {
    Boolean dp[][];
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != (s1.length() + s2.length())) return false;
        dp = new Boolean[s1.length()+1][s2.length()+1];

        return solve(0, 0, 0, s1,s2,s3);
    }

    private boolean solve(int i, int j, int k, String s1, String s2, String s3) {

        if(i == s1.length() && j == s2.length() && k == s3.length()) {
            return true;
        }

        if(i < s1.length() && j < s2.length() && dp[i][j] != null) return dp[i][j];

        char ch = s3.charAt(k);

        if(i < s1.length() && j < s2.length() && ch == s1.charAt(i) && ch == s2.charAt(j)) {
            return dp[i][j] = solve(i+1, j, k+1, s1,s2,s3) || solve(i, j+1, k+1, s1,s2,s3);
        }
        else if (i < s1.length() && ch == s1.charAt(i)) {
            return dp[i][j] = solve(i+1, j, k+1, s1,s2,s3);
        }
        else if(j < s2.length() && ch == s2.charAt(j)) {
            return dp[i][j] = solve(i, j+1, k+1, s1,s2,s3);
        }

        return dp[i][j] = false;
    }
}

/*
s1 has n substring
s2 has m substrings

|n-m| <= 1


i, j, k



*/