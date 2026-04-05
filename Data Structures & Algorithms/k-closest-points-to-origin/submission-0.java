class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double []> pq = new PriorityQueue<>((a,b) -> Double.compare(a[0],b[0]));

        for(int i=0;i<points.length;i++) {
            int point[] = points[i];
            double dist = Math.sqrt((point[0]*point[0]) + (point[1]*point[1]));
            pq.offer(new double[]{dist, (double)i});
        }

        // while(!pq.isEmpty()) {
        //     double temp[] = pq.poll();
        //     System.out.println("temp : "+Arrays.toString(temp));
        // }

        int res[][] = new int[k][2];
        int index = 0;
        while(k -- > 0 && !pq.isEmpty()) {
            double temp[] = pq.poll();
            res[index] = points[(int)temp[1]];
            index++;
        }

        return res;
    }
}

/*



*/
