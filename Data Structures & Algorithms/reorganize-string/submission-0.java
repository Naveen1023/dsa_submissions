class Solution {
    public String reorganizeString(String s) {
                HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<int []> pq = new PriorityQueue<>(new MyComparator());
        StringBuilder res = new StringBuilder("");

        // count freq
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }


        // build max heap
        for(char key : map.keySet()) {
            pq.offer(new int[]{(int)key, map.get(key)});
        }


        while(pq.size() >= 2) {
            int max[] = pq.poll();
            int max2[] = pq.poll();

            res.append((char)max[0]);
            res.append((char)max2[0]);

            max[1] = max[1] -1;
            max2[1] = max2[1] -1;

            if(max[1] > 0) pq.offer(max);
            if(max2[1] > 0) pq.offer(max2);
        }

        if(pq.isEmpty()) return res.toString();
        return (pq.peek()[1] > 1) ? "" : res.append((char)pq.peek()[0]).toString();
    }
    class MyComparator implements Comparator<int []> {
        public int compare(int a[], int b[]) {
            return b[1]-a[1];
        }
    }
}