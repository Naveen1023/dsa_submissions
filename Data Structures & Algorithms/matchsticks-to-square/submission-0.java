class Solution {
    public boolean makesquare(int[] arr) {
        Arrays.sort(arr);

        // sort in desc order to backtrack fast. Collections.reverseOrder() works only on primitve types
        sortInDescOrder(arr);
        
        // System.out.println(Arrays.toString(arr));

        int sum = 0;
        for(int ele : arr) sum+=ele;

        if(sum % 4 != 0) return false;

        int side = sum/4;

        // we need to make the sides equivalent to this
        return solve(0, arr, new int[4], side);
    }

    private boolean solve(int index, int arr[], int sides[], int targetSide) {

        // at current index : add it to the side
        // which side => side + arr[index] <= targetSide
        if(index == arr.length) {
            if(sides[0] == sides[1] && sides[1] == sides[2] && sides[2] == sides[3]) return true;
            return false;
        }

        for(int i=0;i<sides.length;i++) {
            if(sides[i] + arr[index] <= targetSide) {
                sides[i] += arr[index];
                if(solve(index+1, arr, sides, targetSide)) return true;
                sides[i] -= arr[index];
            }
        }

        return false;
    }

    private void sortInDescOrder(int arr[]) {
        int i=0,j=arr.length-1;
        while(i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;j--;
        }
    }
 }