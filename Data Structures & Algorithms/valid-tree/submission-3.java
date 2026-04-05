class Solution {
    int components;
    public boolean validTree(int n, int[][] edges) {
        components = n;
        int parent[] = new int[n];
        int size[] = new int[n];
        for(int i=0;i<n;i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for(int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];

            if(!union(u, v, parent, size)) return false;
        }
        return components == 1;
    }

    private boolean union(int node1, int node2, int parent[], int size[]){
        int parent1 = findParent(node1, parent);
        int parent2 = findParent(node2, parent);

        if(parent1 == parent2) {
            return false;
        }
        // merge into larger size compoenent
        if(size[parent1] >= size[parent2]) {
            parent[parent2] = parent1;
            size[parent1] += size[parent2];
        }
        else {
            parent[parent1] = parent2;
            size[parent2] += size[parent1];
        }
        components--;
        return true;
    }

    private int findParent(int i, int parent[]) {
        if(parent[i] == i) return i;
        return parent[i] = findParent(parent[i], parent);
    }
}
/*
cycle should not exists..

*/