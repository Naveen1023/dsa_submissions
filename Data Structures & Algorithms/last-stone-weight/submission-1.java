class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);

        // Build initial max heap
        for(int ele : stones) pq.offer(ele);

        while(pq.size() > 1) {
            int heaviest = pq.poll();
            int secondHeaviest = pq.poll();

            pq.offer(heaviest - secondHeaviest);
        }
        return pq.peek();
    }
}
/*
2,3,6,2,4
heaviest ? 

appraoch-1 : pick two elements => merge => insert and sort => O(nLogn * n)
approach-2 : max Heap create : O(n) => pop 2 elements, insert(logN) the abs diff
                O(n + nLogn) => O(nLogn)


*/