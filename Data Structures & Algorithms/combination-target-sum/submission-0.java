class Solution {
    Set<List<Integer>> set;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        set = new HashSet<>();

        solve(0, nums, target, new ArrayList<>());
        
        for(List<Integer> list : set) 
            res.add(list);

        return res;
    }

    private void solve(int i, int arr[], int target, List<Integer> list) {

        if(i >= arr.length || target == 0) {
            if(target == 0)
                set.add(new ArrayList<>(list));
            return;
        }

        // choose : repeat same element OR go to next one
        if(arr[i] <= target) {
            list.add(arr[i]);
            solve(i, arr, target-arr[i], list);
            solve(i+1, arr, target-arr[i], list);
            list.remove(list.size()-1);
        }

        // not Choose
        solve(i+1, arr, target, list);
    }
}
