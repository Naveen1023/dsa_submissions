class Solution {
    int dirX[] = {1,0,-1,0};
    int dirY[] = {0,1,0,-1};
    public void islandsAndTreasure(int[][] arr) {
        Queue<int []> q = new LinkedList<>();

        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[0].length;j++) {
                if(arr[i][j] == 0) {
                    bfs(i,j,arr);
                    // System.out.println("after bfs from : i="+i+", j="+j); 
                    for(int a[] : arr) {
                        System.out.println(Arrays.toString(a));
                    }
                }
            }
        }
    }

    private void bfs(int i, int j, int arr[][]) {
        Queue<int []> q = new LinkedList<>();
        q.offer(new int[]{i,j,0}); // row, col, dist from 0

        HashSet<String> set = new HashSet<>();

        while(!q.isEmpty()) {
            int qSize = q.size();

            while(qSize-- > 0) {
                int curr[] = q.poll();

                // System.out.println("\t processing for curr : "+Arrays.toString(curr));
                arr[curr[0]][curr[1]] = Math.min(curr[2], arr[curr[0]][curr[1]]);
                // System.out.println("\t value for curr : "+arr[curr[0]][curr[1]]);

                set.add(curr[0]+"_"+curr[1]);

                for(int k=0;k<4;k++) {
                    int newI = curr[0] + dirX[k];
                    int newJ = curr[1] + dirY[k];

                    // System.out.println("newI="+newI+", newJ="+newJ); 
                    // System.out.println(set.contains(curr[0]+"_"+curr[1]));

                    if(newI >= 0 && newI < arr.length &&
                    newJ >= 0 && newJ < arr[0].length &&
                    arr[newI][newJ] != -1 && 
                    !set.contains(newI+"_"+newJ)) {
                        q.offer(new int[]{newI, newJ, curr[2]+1});
                    }
                }
            }
        }
    }
}
/*
- get all the INF cells
- start BFS one by one and store the answers
-(V + E) * v


Instead, start from the 0 treasure cells
*/
