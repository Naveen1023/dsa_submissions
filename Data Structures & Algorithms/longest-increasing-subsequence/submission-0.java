class Solution {
    public int lengthOfLIS(int[] arr) {
        int result = 1;
        int res[] = new int[arr.length];
        res[0] = 1;

        for(int i=1;i<arr.length;i++) {
            //go backwards and find the candidate(which is lesser)
            int j = i-1;
            int currLen = 1;
            while(j >= 0) {
                if(arr[j] < arr[i]) {
                    currLen = Math.max(currLen, 1 + res[j]);
                }
                j--;
            }
            res[i] = currLen;
            result = Math.max(result, res[i]);
            // System.out.println("i : "+i+"res[i] : "+res[i]);
        }

        return result;
    }
}

/*
App-1 : from every index, go towards right, find greater element, if new greater < prevGreater => prevGreater = newGreater
        maintain count => O(n^2)


App-1 : 
*/