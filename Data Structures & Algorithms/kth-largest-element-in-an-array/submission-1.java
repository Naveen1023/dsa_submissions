class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a-b); // min heap

        for(int ele : nums) {
            if(pq.size() < k) {
                pq.offer(ele);
                // System.out.println("ele : "+ele+" is directly inserted....");
                continue;
            }

            if(!pq.isEmpty() && pq.peek() < ele) { // poll and insert current
                // System.out.println("size is more, popping: "+pq.peek()+", inserting : "+ele);
                pq.poll();
                pq.offer(ele); 
            }
        }

        return pq.peek();
    }
}


/*
smallest of top k largest elements
min heap of max elements
[-1,2,0]

=> Heap : 0,2



*/