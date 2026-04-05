class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] ans = new int[n];
        int[][] extTasks = new int[n][3];
        for(int i = 0; i < n; i++) {
            extTasks[i][0] = i;
            extTasks[i][1] = tasks[i][0];
            extTasks[i][2] = tasks[i][1];
        }
        Arrays.sort(extTasks, (a,b)->a[1] - b[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[2] == b[2] ? a[0] - b[0] : a[2] - b[2]); // 
        

        int time = 1;
        int index = 0;
        int ansIndex = 0;
        while(ansIndex < ans.length) {
            while(index < extTasks.length && extTasks[index][1] <= time) {
                pq.offer(extTasks[index]);
                index++;
            }

            if(pq.isEmpty()) {
                time = extTasks[index][1];
                continue;
            }
            int bestFit[] = pq.poll();
            time += bestFit[2];
            ans[ansIndex++] = bestFit[0];
        }

        return ans;
    }
}