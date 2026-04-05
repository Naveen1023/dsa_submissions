class Solution {
    public int[] findOrder(int n, int[][] arr) {
        int inDeg[] = new int[n];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++) map.put(i, new ArrayList<>());
        List<Integer> list = new ArrayList<>();

        for(int a[] : arr) {
            int v = a[0];
            int u = a[1];
            inDeg[v]++;
            map.get(u).add(v);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<inDeg.length;i++) {
            if(inDeg[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()) {
            int curr = q.poll();
            inDeg[curr] = -1;
            list.add(curr);
            for(int neigh : map.get(curr)) {
                inDeg[neigh]--;
                if(inDeg[neigh] == 0) q.offer(neigh);
             }
        }

        for(int i=0;i<inDeg.length;i++) {
            if(inDeg[i] > 0) return new int[]{};
            else if (inDeg[i] != -1) list.add(i);
        }
        int res[] = new int[list.size()];
        int index = 0;
        for(int temp : list){
            res[index++] = temp;
        }

        return res;
    }
}

/*
[0,1] => 1 -> 0 edge

topo sort : 
- find nodes with inDeg 0 => put them in queue
- kepp polling one by one : 
    reduce the neigh inDeg by 1 
    if new inDeg becomes 0 => put in the Queue

- order of polling from the queue is the order of processing 

*/