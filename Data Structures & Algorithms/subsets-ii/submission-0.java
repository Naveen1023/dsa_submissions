class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();

        Arrays.sort(nums);
        solve(0, nums, new ArrayList<>());
        
        return res;
    }

    private void solve(int index, int arr[], List<Integer> list) {

        res.add(new ArrayList<>(list));

        for(int i=index;i<arr.length;i++) {

            if(i > index && arr[i] == arr[i-1]) continue;

            list.add(arr[i]);
            solve(i+1, arr, list);
            list.remove(list.size()-1);
        }
    }
}

/*
 0,1,2
[1,1,2]

f(0) []
    0 f(1) [1]
        1 f(2) [1,1]
            2 f(3) [1,1,3]
        2 f(3) [1,2]
    1 f(2) [1]
        2 f(3) [1,2]
    2 f(3) [2]
        

    
*/
