class Solution {
    public int trap(int[] arr) {
        int leftMax[] = new int[arr.length];
        int rightMax[] = new int[arr.length];
        int res = 0;

        leftMax[0] = 0;
        rightMax[arr.length-1] = 0;

        for(int i=1;i<arr.length;i++){
            leftMax[i] = Math.max(arr[i-1], leftMax[i-1]);
        }
        for(int i=arr.length-2;i>=0;i--){
            rightMax[i] = Math.max(arr[i+1], rightMax[i+1]);
        }


        // System.out.println("LeftMax : "+Arrays.toString(leftMax));
        // System.out.println("RightMax : "+Arrays.toString(rightMax));


        for(int i=1;i<arr.length-1;i++){
            int water = Math.min(leftMax[i], rightMax[i]) - arr[i];
            if(water > 0) res += water;
        }

        return res;
    }
}
/*
every index can have some water on top => depends on min(heighest left bar, heightest right baar)

i => find out max towards left, findout max towards right
water over that index = min(leftheight, rightHeight) - height[i];

App.-1 : find out for every index O(n^2)\
App-2 : pre-calculate, max from both side

*/