class Solution {
    public int findMin(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        int res = -1;
        while(left <= right) {
            int mid = (left + right)/2;
            System.out.println("left : "+left+", right : "+right+", arr[mid] : "+arr[mid]);
            if(mid-1 >= 0 && arr[mid] < arr[mid-1]) { // this is the answer
                res = arr[mid];
                return res;
            }
            else if(arr[mid] >= arr[0]) {
                left = mid+1;
            }
            else right = mid-1;
        }
        return arr[0];
    }
}

/*

App-1 : in one time only
i = 0;
j = n-1;

3,4,5,6,1,2
0 1 2 3 4 5
      i   j


mid = 2

if(arr[mid] > arr[i])

*/
