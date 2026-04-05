class Solution {
    int visited[][];
    int resSize;
    int dirX[] = {1,0,-1,0};
    int dirY[] = {0,1,0,-1};
    public int maxAreaOfIsland(int[][] grid) {
        visited = new int[grid.length][grid[0].length];
        resSize = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(visited[i][j] == 0 && grid[i][j] == 1) {
                    int islandSize = dfs(i, j, grid, new int[grid.length][grid[0].length]);
                    // System.out.println("size : "+islandSize+", i : "+i+", j : "+j);
                    resSize = Math.max(islandSize, resSize);
                }
            }
        }
        return resSize;
    }

    private int dfs(int i, int j, int arr[][], int currVisited[][]) {
        currVisited[i][j] = 1;
        visited[i][j] = 1;
        int islandSize = 1;
        //call horizontally and vertically is neighbour is valid and unvisited
        for(int k=0;k<4;k++) {
            int newI = i + dirX[k];
            int newJ = j + dirY[k];

            if((newI >= 0 && newI < arr.length) &&
                newJ >= 0 && newJ < arr[0].length && 
                currVisited[newI][newJ] == 0 && arr[newI][newJ] == 1) {
                    islandSize += dfs(newI, newJ, arr, currVisited);
                }
        }
        return islandSize;
    }
}
/*
scan through the matrix : 
    if there is 1 (unvisited => maintain global visited array) : 
        size = will the start DFS
        maintain a global maxima of size
*/
