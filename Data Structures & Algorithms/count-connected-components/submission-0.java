class Solution {
    int components;
    public int countComponents(int n, int[][] edges) {
        components = n;
        int parent[] = new int[n];
        int size[] = new int[n];

        for(int i=0;i<n;i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for(int a[] : edges) {
            int u = a[0];
            int v = a[1];

            union(u, v, parent, size);
        }

        return components;
    }

    private void union(int node1, int node2, int parent[], int size[]) {
        int parent1 = findParent(node1, parent);
        int parent2 = findParent(node2, parent);

        if(parent1 == parent2) return;

        if(size[parent1] < size[parent2]) { // merge into parent2
            parent[parent1] = parent2;
            size[parent2] += size[parent1];
        }
        else {
            parent[parent2] = parent1;
            size[parent1] += size[parent2];
        }

        components--;
    }

    private int findParent(int node, int parent[]) {
        if(node == parent[node]) return node;
        return parent[node] = findParent(parent[node], parent);
    }
}
