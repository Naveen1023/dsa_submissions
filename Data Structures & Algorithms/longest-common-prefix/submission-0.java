class Solution {
    public String longestCommonPrefix(String[] arr) {
        // pointer to element, pointer to inner index
        StringBuilder res = new StringBuilder("");
        boolean shouldCheck = true;
        int index = 0;
        while(shouldCheck && index < arr[0].length()) {
            Character currChar = arr[0].charAt(index);
            for(int i=1;i<arr.length;i++) {
                String currString = arr[i];
                if(index >= currString.length() || (currString.charAt(index) != currChar)) {
                    shouldCheck = false;
                    break;
                }
            }
            if(shouldCheck) {
                res.append(currChar);
                index++;
            }
        }

        return res.toString();
    }
}

/*
["abc", "abc", "a"]
false, 2
res = "ba"
*/