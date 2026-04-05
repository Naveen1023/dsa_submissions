class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i =0;
        int j = 0;
        int res = 0;
        HashSet<Character> set = new HashSet<>();
        while(j < s.length()) {
            char ch = s.charAt(j);

            while(set.contains(ch)) {
                set.remove(s.charAt(i++));
            }

            set.add(ch);
            res = Math.max(res, set.size());
            // System.out.println("i = "+i+",j = "+j+", res : "+res);
            j++;
        }

        return res;
    }
}
