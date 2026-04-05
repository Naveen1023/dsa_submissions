class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        int row = findLowerBoundRow(arr, target);
        // System.out.println("lower bound row : "+row);

        if(row == -1) return false;

        return doesElementExistInThatRow(row, arr, target);
    }

    private int findLowerBoundRow(int arr[][], int target) {
        int low = 0;
        int high = arr.length-1;
        int lastCol = arr[0].length-1;
        int res = -1;
        while(low <= high) {
            int midRow = (low + high)/2;

            if(target >= arr[midRow][0] && target <= arr[midRow][lastCol]) {
                res = midRow;
                break;
            }
            else if(target > arr[midRow][lastCol]) {
                low = midRow+1;
            }
            else high = midRow-1;
        }

        return res;
    }

    private boolean doesElementExistInThatRow(int row, int arr[][], int target) {
        int low = 0;
        int high = arr[0].length-1;
        

        while(low <= high) {
            int mid = (low + high)/2;

            if(target == arr[row][mid]) return true;
            else if(target < arr[row][mid]) high = mid-1;
            else low = mid+1;
        }

        return false;
    }
}

/*
1. find the lower bound in row wise
2. search in that row
*/
