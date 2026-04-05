class Solution {
    public int maxArea(int[] heights) {
        int res = 0;
        int i=0;
        int j = heights.length-1;


        while(i < j) {
            int water = (j-i) * Math.min(heights[i],heights[j]);
            res = Math.max(res, water);

            if(heights[i] <= heights[j]) i++;
            else j--;
        }

        return res;
    }
}

/*
App-1 : every possible subArray => O(n^2) => keep the global maxima
sort -> no
App-2 : breadth * height of the bars
        i = 0
        j = n
        water = (j-i-1) * min(a[i], a[j]); => compare with maxima     


*/