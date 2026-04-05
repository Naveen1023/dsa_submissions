class Solution {
    public int removeDuplicates(int[] arr) {
        int index = 0;
        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<arr.length;i++) {
            if(!set.contains(arr[i])) {
                arr[index] = arr[i];
                index++;
            }
            set.add(arr[i]);
        }

        return index;
    }
}