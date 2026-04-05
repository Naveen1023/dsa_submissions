class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder("");
        int i =0;
        int j = 0;

        boolean isWordOneTurn = true;
        while(i < word1.length() && j < word2.length()) {
            char ch = (isWordOneTurn == true) ? word1.charAt(i++) : word2.charAt(j++);
            res.append(ch);
            isWordOneTurn = !isWordOneTurn;

        }

        while(i < word1.length()) res.append(word1.charAt(i++));
        while(j < word2.length()) res.append(word2.charAt(j++));

        return res.toString();
    }
}