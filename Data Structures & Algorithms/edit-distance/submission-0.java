class Solution {
    int dp[][];
    public int minDistance(String word1, String word2) {
        dp = new int[word1.length()][word2.length()];

        for(int a[] : dp) Arrays.fill(a, -1);

        return solve(0,0, word1, word2);
    }

    private int solve(int i, int j, String s1, String s2) {

        if(i >= s1.length()) { // remaining from s2 needs to be inserted
            return s2.length()-j;
        }
        else if(j >= s2.length()) { // remaining from s1 needs to be removed
            return s1.length()-i;
        }

        if(s1.charAt(i) == s2.charAt(j)) {
            return solve(i+1, j+1, s1, s2);
        }

        if(dp[i][j] != -1) return dp[i][j];
        int ops = Integer.MAX_VALUE;
        // 3 options 
        //INSERT the character => jth char is now automatically matched
        ops = 1 + solve(i, j+1, s1,s2);

        // REMOVE the character => ith got removed => jth still needs to be matched
        ops = Math.min(ops, 1 + solve(i+1, j, s1,s2));

        // REPLACE => both are matched, move to next chars in both
        ops = Math.min(ops, 1 + solve(i+1, j+1, s1,s2));

        return dp[i][j] = ops;
    }
}
/*
w1, w2

insert
delete
replace

i,j

if i == j => no change & proceed
else 
    insert jth char in word1 => monekeys
    delete ith char in word1 => moneys
    replace ith char with jth char => moneeys

monkeys
money






*/
