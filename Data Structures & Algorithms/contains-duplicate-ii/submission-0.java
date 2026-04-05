class Solution {
    public boolean containsNearbyDuplicate(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;

        while(j < arr.length) {
            map.put(arr[j], map.getOrDefault(arr[j], 0)+1);

            while(j-i+1 > k+1) { // window exceeds k, shrink remove arr[i]
                map.put(arr[i], map.get(arr[i]) - 1);
                if(map.get(arr[i]) == 0) map.remove(arr[i]);                
                i++;
            }

            if(map.get(arr[j]) > 1) return true;
            j++;

        }
        
        return false;
    }
}