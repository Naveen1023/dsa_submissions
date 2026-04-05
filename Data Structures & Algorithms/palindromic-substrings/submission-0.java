class Solution {
    public int countSubstrings(String s) {
        char arr[] = s.toCharArray();
        int res = 0;

        // consider index as center of the palindrome
        for(int index = 0;index<s.length();index++) {
            //odd length palindrome
            int count = 1; // curr char

            int left = index-1, right = index+1;
            while(left >= 0 && right < s.length() && arr[left] == arr[right]) {
                left--;
                right++;
                count++;
            }

            //even length
            left = index;
            right = index+1;
            while(left >= 0 && right < s.length() && arr[left] == arr[right]) {
                left--;
                right++;
                count++;
            }

            res += count;
        }

        return res;
    }
}
