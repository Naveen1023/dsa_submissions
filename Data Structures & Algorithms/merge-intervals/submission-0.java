class Solution {
    public int[][] merge(int[][] arr) {
        List<int []> list = new ArrayList<>();
        int index = 1;

        Arrays.sort(arr, (a,b) -> a[0]- b[0]);

        int start = arr[0][0];
        int end = arr[0][1];

        while(index < arr.length) {
            int curr[] = arr[index];

            if(curr[0] <= end) { // overlap, continue merging
                end = Math.max(end, curr[1]);
            }
            else{
                list.add(new int[]{start, end});
                start = curr[0];
                end = curr[1];
            }
            index++;
        }
        list.add(new int[]{start, end});

        return list.toArray(new int[list.size()][]);
    }
}
