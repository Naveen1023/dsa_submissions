class Solution {
    public int findJudge(int n, int[][] trust) {
        int arr[] = new int[n+1];

        for(int[] ele : trust) {
            arr[ele[1]]++; //received trust
            arr[ele[0]]--; // gave trust
        }

        for(int i=1;i<arr.length;i++) {
            if(arr[i] == (n-1)) return i;
        }
        return -1;
    } 
}