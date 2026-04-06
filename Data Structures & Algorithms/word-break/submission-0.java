class Solution {
    Boolean dp[];
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new Boolean[s.length()];
        HashSet<String> set = new HashSet<>();

        for(String word : wordDict) set.add(word);

        return solve(0, s, set);
    }

    private boolean solve(int index, String s, HashSet<String> set) {

        if(index == s.length()) return true;

            if(dp[index] != null) return dp[index];
        for(int i=index;i<s.length();i++) {
            String temp = s.substring(index, i+1);
            if(!set.contains(temp)) continue;

            if(solve(i+1, s, set)) return true;
        }

        return dp[index] = false;
    }
}
