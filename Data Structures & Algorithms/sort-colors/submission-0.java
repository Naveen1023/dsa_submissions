class Solution {
    public void sortColors(int[] arr) {
        int zeros = 0, ones = 0;

        for(int ele : arr) {
            if(ele == 0) zeros++;
            else if (ele == 1) ones++;
        }
        putValues(zeros, 0, arr, 0);
        putValues(ones, 1, arr, zeros);
        putValues(arr.length-(zeros+ones), 2, arr, zeros+ones);
    }

    public void putValues(int counter, int value, int[] arr, int index) {
        while(counter-- > 0) {
            arr[index++] = value;
        }
    }
}

/*
0, 1, 2 element



*/