class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        
        Arrays.sort(candidates);
        solve(0, candidates, target, new ArrayList<>());

        return res;
    }

    private void solve(int index, int arr[], int target, List<Integer> list) {

        if(target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i=index;i<arr.length;i++) {
            if(arr[i] > target) return;
            if(i > index && arr[i] == arr[i-1]) continue;
            list.add(arr[i]);
            solve(i+1, arr, target-arr[i], list);
            list.remove(list.size()-1);
        }
    }
}


/*
[9,2,2,4,6,1,5]
[1,2,2,4,5,6,9], target = 8
    1
   (2)  (2) 
  (5)   
*/

