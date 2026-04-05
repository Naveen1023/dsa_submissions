class Solution {
    static List<List<Integer>> res;
    static HashSet<List<Integer>> set;
    public List<List<Integer>> permuteUnique(int[] arr) {
        res = new ArrayList<>();
        set = new HashSet<>();

        solve(0,arr);
        for(List<Integer> list : set) res.add(list);

        return res;
    }

    private static void solve(int index, int arr[]) {
        if(index == arr.length) {
            List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
            set.add(list);
            return;
        }
        for(int i=index;i<arr.length;i++){
            swap(i,index,arr);
            solve(index+1, arr);
            swap(i,index,arr);
        }
    }
    private static void swap(int i, int j, int arr[]) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}