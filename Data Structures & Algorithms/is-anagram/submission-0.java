class Solution {
    public boolean isAnagram(String s, String t) {
        int f1[] = new int[26];
        int f2[] = new int[26];
        
        // count the frequency of characters 
        for(int i=0;i<s.length();i++) {
            f1[s.charAt(i) - 'a']++;
        }
        for(int i=0;i<t.length();i++) {
            f2[t.charAt(i) - 'a']++;
        }

        // compare and return
        for(int i=0;i<26;i++) {
            if(f1[i] != f2[i]) return false;
        }

        return true;
    }
}

/*
1. sort both -> compare -> every elements should match -> O(nLogn)
2. counth freq of both string -> match -> O(n)


*/
