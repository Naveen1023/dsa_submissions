class Solution {
    public int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length-1;

        int firstElementIndex = findFirst(arr);

        // System.out.println("first Element Index : "+firstElementIndex);

        int leftSearch = searchBinary(0, firstElementIndex-1, arr, target);
        if(leftSearch != -1) return leftSearch;

        int rightSearch = searchBinary(firstElementIndex, arr.length-1, arr, target);
        
        return rightSearch;

    }

    private int searchBinary(int left, int right, int arr[], int target) {
        if(left < 0 || left >= arr.length || right < 0 || right >= arr.length) return -1;

        while(left <= right) {
            int mid = (left + right)/2;

            if(target == arr[mid]) return mid;
            else if(target > arr[mid]) left = mid+1;
            else right = mid-1;
        }

        return -1;
    }

    private int findFirst(int arr[]) {
        int left=0, right=arr.length-1;
        int res = -1;
        while(left <= right) {
            int mid = (left + right) / 2;

            if(mid > 0 && arr[mid] < arr[mid-1]) return mid;

            if(arr[mid] > arr[right]) { // means we are in first increasing sequence
                left = mid+1;
            }
            else right = mid-1;
        }

        return 0;
    }
}
