class Solution {
    public int[] minInterval(int[][] arr, int[] givenQueries) {
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]); //  end, sizeOfInterval
        int res[] = new int[givenQueries.length];
        Arrays.sort(arr, (a,b) -> a[0]-b[0]);
        int queries[] = givenQueries.clone();
        Arrays.sort(queries); // asecnding order
        HashMap<Integer, Integer> map = new HashMap<>();
        int index = 0;
        int arrIndex = 0;

        while(index < queries.length) {
            int curr = queries[index];

            // put matching candidates in pq
            while(arrIndex < arr.length && arr[arrIndex][0] <= curr) {
                // System.out.println("putting in pq  curr : "+curr+" arr : "+Arrays.toString(arr[arrIndex]));
                pq.offer(new int[]{arr[arrIndex][1], arr[arrIndex][1]-arr[arrIndex][0]+1});
                arrIndex++;
            }

            // pop all expired candidates basis end time => if endtime < curr => definately not matching
            while(!pq.isEmpty() && pq.peek()[0] < curr) {
                pq.poll();
            }

            // get the smallest matching candidate and set in result
            int temp = -1;
            if(!pq.isEmpty()) { temp = pq.peek()[1]; }
            map.put(curr, temp);
            // System.out.println("\t shortest matching : "+temp);
            index++;
        }

        for(int i=0;i<givenQueries.length;i++) {
            res[i] = map.get(givenQueries[i]);
        }

        return res;

    }
}
/*
query index : 
    at index : put all the intervals in pq where startTime < curr

*/
