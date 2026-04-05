class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        solve(0, nums, new ArrayList<>());

        return res;
    }

        private void solve(int i , int arr[], List<Integer> list) {

        if(i >= arr.length) { 
            res.add(new ArrayList<>(list));
            return;
        }

        solve(i+1, arr, list); // not choose
        list.add(arr[i]);
        solve(i+1, arr, list); // choose
        list.remove(list.size()-1);
    }
}
