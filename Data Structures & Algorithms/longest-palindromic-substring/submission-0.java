class Solution {
    Boolean dp[][];
    public String longestPalindrome(String s) {
        dp = new Boolean[s.length()][s.length()];
        String res = "";
        for(int i=0;i<s.length();i++) {
            for(int j=i;j<s.length();j++) {
                if(isPalindrome(i, j, s)) {
                    if((j-i+1) > res.length()) {
                        res = s.substring(i,j+1);
                    }
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(int i, int j, String str) {
        if(dp[i][j] != null) return dp[i][j];

        while(i < j) {
            if(str.charAt(i) != str.charAt(j)) return dp[i][j] = false;
            i++;j--;
        }

        return dp[i][j] = true;
    }
}
/*
for i=0 to n
    for j=0 to n : 
        checkifPalindrome(i,j+1)

 O(n^3)



*/
