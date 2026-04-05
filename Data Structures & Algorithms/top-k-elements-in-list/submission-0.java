class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        // (element, freq)

        for(int ele : nums) {
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }

        for(int ele : map.keySet()) {
            int freq = map.get(ele);
            if(pq.size() < k) {
                pq.offer(new int[]{ele, freq});
            }
            else {
                if(freq > pq.peek()[1]) {
                    pq.poll();
                    pq.offer(new int[]{ele, freq});
                }
            }
        }

        int res[] = new int[k];
        int index = 0;
        while(!pq.isEmpty()) {
            res[index++] = pq.poll()[0];
        }
        return res;
    }
}

/*
sort and count : nLogn, O(1) space
*/