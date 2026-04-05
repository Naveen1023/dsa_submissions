class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = findUpperBound(arr, x);
        List<Integer> res= new ArrayList<>();

        // System.out.println("upperBound index : "+index);

        int i = index-1;
        int j = index;

        while(i >= 0 && j < arr.length && res.size() < k) {
            int left = (int)Math.abs(x - arr[i]);
            int right = (int)Math.abs(x - arr[j]);

            if(left <= right) {
                res.add(arr[i]);
                i--;
            }
            else res.add(arr[j++]);
        }

        while(j < arr.length && res.size() < k) {
            res.add(arr[j++]);
        }

        while(i >= 0 && res.size() < k) {
            res.add(arr[i--]);
        }
        Collections.sort(res);
        return res;

    }

    private int findUpperBound(int arr[], int target) {
        int low = 0;
        int high = arr.length-1;
        int res = arr.length-1;

        while(low <= high) {
            int mid = (low+high)/2;

            if(target <= arr[mid]) {
                res = mid;
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }

        return res;
    }
}

/*
- binary search (closest, let's go with upper bound)
- on index : 
    go index-1. index+1 till we find closest k elements

O(logn) + O(n)
*/