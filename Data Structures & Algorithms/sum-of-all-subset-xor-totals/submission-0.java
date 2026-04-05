class Solution {
    int res;
    public int subsetXORSum(int[] nums) {
        res = 0;
        solve(0, nums, new ArrayList<>());
        return res;
    }

    private void solve(int i , int arr[], List<Integer> list) {

        if(i >= arr.length) { // xor whatever is there in list
            if(list.size() == 0) return;

            int xor = list.get(0);

            for(int index = 1; index < list.size();index++) {
                xor = xor ^ list.get(index);
            }

            res += xor;
            return;
        }

        solve(i+1, arr, list); // not choose;
        list.add(arr[i]);
        solve(i+1, arr, list);
        list.remove(list.size()-1);
    }
}
/*
generte every subset
find out the XOR and sum with res


[2,5,6] 
[], [2] , [5], [6], [2,5], [2,6], [5,6], [2,5,6]

2^3 = 8 subsets

O(n * 2^n)

*/