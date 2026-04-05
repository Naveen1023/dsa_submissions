class Solution {
    public boolean validPalindrome(String s) {
        int i =0;
        int j = s.length()-1;

        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return isPalindrome(i+1,j,s) || isPalindrome(i,j-1,s);
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isPalindrome(int i, int j, String s) {
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}