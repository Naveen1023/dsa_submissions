class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();

        solve(0, nums);

        return res;
    }

    private void solve(int index, int arr[]) {

        if(index == arr.length) {
            List<Integer> list = new ArrayList<>();
            for(int ele : arr) list.add(ele);

            res.add(list);
            return; 
        }

        for(int i=index;i<arr.length;i++) {
            swap(index, i, arr);
            solve(index+1, arr);
            swap(index, i, arr);
        }
    }

    private void swap(int i, int j, int arr[]) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

/*
[1,2,3]
*/
