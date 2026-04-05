class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);

        HashSet<List<Integer>> set = new HashSet<>();
        for(int i=0;i<arr.length-2;i++) {
            if(i > 0 && arr[i] == arr[i-1]) continue;
            int j = i+1;
            int k = arr.length-1;
            int target = -arr[i];
            int sum = 0;
            while(j < k) {
                sum = arr[j] + arr[k];
                // System.out.println("i = "+i+",j= "+j+", k= "+k+", sum = "+sum);
                if(sum == target) {
                    set.add(Arrays.asList(arr[i],arr[j],arr[k]));
                    j++;
                }
                else if(sum < target) {
                    j++;
                }
                else k--;
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        for(List<Integer> list : set) {
            res.add(list);
        }

        return res;
    }
}
