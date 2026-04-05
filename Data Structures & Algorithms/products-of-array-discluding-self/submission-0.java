class Solution {
    public int[] productExceptSelf(int[] arr) {
        int pre[] = new int[arr.length];
        int post[] = new int[arr.length];

        pre[0] = 1;
        for(int i =1;i<arr.length;i++) {
            pre[i] = pre[i-1] * arr[i-1];
        }

        post[arr.length-1] = 1;
        for(int i =arr.length-2;i>=0;i--) {
            post[i] = arr[i+1] * post[i+1];
        }

        int res[] = new int[arr.length];


        for(int i=0;i<arr.length;i++) {
            res[i] = pre[i] * post[i];
        }

        return res;

    }
}  
