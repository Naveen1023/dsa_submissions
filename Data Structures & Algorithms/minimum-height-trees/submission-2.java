class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int inDeg[] = new int[n];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();

        for(int a[] : edges) {
            inDeg[a[0]]++;
            inDeg[a[1]]++;

            map.putIfAbsent(a[0], new ArrayList<>());
            map.putIfAbsent(a[1], new ArrayList<>());
            map.get(a[0]).add(a[1]);
            map.get(a[1]).add(a[0]);
        }

        for(int i=0;i<n;i++) {
            if(inDeg[i] == 0 || inDeg[i] == 1) q.offer(i);
        }

        int last = -1;
        int last2 = -1;
        while(n > 2) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                int node = q.poll();
                for(int neigh : map.get(node)) {
                    inDeg[neigh]--;
                    if(inDeg[neigh] == 1) q.offer(neigh);
                }
            }
            n-=size;
        }

        List<Integer> res = new ArrayList<>();
        
        while(!q.isEmpty()) {
            res.add(q.poll());
        }

        return res;
    }
}
/*
keep removing nodes with smallest inDeg

khann algo but operating at inDeg = 1
*/