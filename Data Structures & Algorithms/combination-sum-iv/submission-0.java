class Solution {
    HashMap<Integer, Integer> dp;
    public int combinationSum4(int[] arr, int target) {
        dp = new HashMap<>();
        Arrays.sort(arr);
        return solve(0, target, arr);
    }

    private int solve(int index, int target, int arr[]) {

        if(target == 0) return 1;
        // if(index == arr.length) return 0;
        int count = 0;

        if(dp.containsKey(target)) return dp.get(target);

        for(int i=0;i<arr.length;i++) {
            if(arr[i] <= target) {
                count += solve(i, target-arr[i], arr);
            }
            else break;
        }
        dp.put(target, count);
        return count;
    }
}