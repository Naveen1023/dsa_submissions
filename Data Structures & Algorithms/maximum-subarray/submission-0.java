class Solution {
    int res = Integer.MIN_VALUE;
    public int maxSubArray(int[] arr) {
        int i =0;
        int j = 0;
        int sum = 0;
        while(j < arr.length) {
            sum += arr[j];
            res = Math.max(res, sum);
            // System.out.println("i = "+i+", j ="+j+", sum = "+sum);
            while(i <= j && sum < 0) {
                sum -= arr[i];
                i++;
            }
            j++;
        }
        return res;
    }
}

/*
2,-3,4,-2,2,1,-1,4

- for every subArray => find sum, compare with global result and update
  O(n^2)
    i = 0 to n-1:
        j = i to n-1:
            sum+=arr[j];
            if(sum > res) => res = sum;
    sum=0;

- window of i,j, keep on adding to window if arr[j] still gives positive
the moemnt it becomes -ve, reset the window, do not carry the -ve.
*/