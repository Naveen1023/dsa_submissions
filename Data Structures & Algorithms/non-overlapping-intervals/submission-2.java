class Solution {
    public int eraseOverlapIntervals(int[][] arr) {

        Arrays.sort(arr, (a,b) -> a[0]-b[0]);

        int start = arr[0][0];
        int end = arr[0][1];
        int index = 1;
        int res = 0;
        
        while(index < arr.length) {
            int curr[] = arr[index];

            if(curr[0] < end) { // overlap is there, need to do something
                end = Math.min(end, curr[1]); // ignoring the bigger interval
                res++;
            }
            else { // no overlap
                start = curr[0];
                end = curr[1];
            }
            index++;
        }

        return res;
    }
}
