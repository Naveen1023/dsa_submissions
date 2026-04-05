class Solution {
    public boolean canFinish(int n, int[][] arr) {
        int inDeg[] = new int[n];
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        // find indegrees
        for(int a[] : arr) {
            int u = a[0];
            int v = a[1];
            inDeg[u]++;

            map.putIfAbsent(u, new ArrayList<>());
            map.putIfAbsent(v, new ArrayList<>());
            map.get(v).add(u);
        }

        // get nodes with 0 indeg can be processed;
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=0;i<n;i++) {
            if(inDeg[i] == 0) q.offer(i);
        }


        while(!q.isEmpty()) {
            int node = q.poll();
            // System.out.println("node : "+node+" is processed...");

            // reduce indegree of all the neighbours
            if(map.containsKey(node) == false) continue;
            
            for(int neigh: map.get(node)) {
                inDeg[neigh]--;
                if(inDeg[neigh] == 0) q.offer(neigh);
            }
        }

        for(int ele : inDeg) {
            if(ele != 0) return false;
        }
        
        return true;
    }
}
