class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        solve(0, s, new ArrayList<>());

        return res;
    }

    private void solve(int index, String s, List<String> list) {

        if(index == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i=index;i<s.length();i++) {
            String temp = s.substring(index, i+1);
            if(isPalindrome(temp)) {
                list.add(temp);
                solve(i+1, s, list);
                list.remove(list.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int i=0,j=s.length()-1;

        while(i <= j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}

/*
aabaacd

for every substring in given string => check if palindrome or not
YES : call on remaining string
NO : skip and check next substring

*/
