class Solution {
    public int minSubArrayLen(int target, int[] arr) {
        int res = Integer.MAX_VALUE;
        int j = 0;
        int i = 0;
        int sum = 0;

        while(j < arr.length) {
            sum += arr[j];
            // System.out.println("i="+i+", j= "+j+", sum = "+sum);
            while(sum >= target && i <= j ) {
                // System.out.println("\t shirnking i="+i+", j= "+j+", sum = "+sum);
                res = Math.min(res, j-i+1);
                sum -= arr[i++];
            }
            j++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}