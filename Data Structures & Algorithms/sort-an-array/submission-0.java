class Solution {
    public int[] sortArray(int[] arr) {
        arr = divideAndSort(0, arr.length-1, arr);
        return arr;
    }


    public int[] divideAndSort(int start, int last, int arr[]) {

        if((last-start+1) == 1) { // 1 element array, already sorted
            return new int[]{arr[start]};
        }


        int mid = (start + last)/2;

        int left[] = divideAndSort(start, mid, arr);
        int right[] = divideAndSort(mid+1, last, arr);

        int[] mergedArray = merge(left, right);
        
        return mergedArray;
    }

    public int[] merge(int a1[], int a2[]) {
        int i = 0;
        int j = 0;

        int res[] = new int[a1.length+a2.length];
        int index = 0;
        while(i < a1.length && j < a2.length) {
            if(a1[i] < a2[j]) {
                res[index++] = a1[i++];
            }
            else res[index++] = a2[j++];
        }
        while(i < a1.length) res[index++] = a1[i++];
        while(j < a2.length) res[index++] = a2[j++];

        return res;
    }

}