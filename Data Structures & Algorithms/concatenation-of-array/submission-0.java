class Solution {
    public int[] getConcatenation(int[] arr) {
        int n = arr.length;
        int res[] = new int[2*n];

        for(int i=0;i < res.length;i++) {
            int index = i % n;
            res[i] = arr[index];
        }
        return res;
    }
}