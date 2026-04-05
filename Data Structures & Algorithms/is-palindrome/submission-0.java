class Solution {
    public boolean isPalindrome(String s) {
        int i =0,j=s.length()-1;

        while(i < j) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);

            if(!isAlphnumeric(ch1)) {
                i++;
                continue;
            }
            if(!isAlphnumeric(ch2)) {
                j--;
                continue;
            }

            if(Character.toLowerCase(ch1) != Character.toLowerCase(ch2)) return false;
            else {
                i++;
                j--;
            }
        }
        return true;
    }

    public boolean isAlphnumeric(char ch) {
        return Character.isLetterOrDigit(ch);
    }
}
