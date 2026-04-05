class Solution {
    static int storedPaths[][];
    public int uniquePaths(int m, int n) {
        storedPaths = new int[m+1][n+1];

        for(int a[] : storedPaths)
            Arrays.fill(a, -1);

        return solve(1,1, m,n);
    }

    public int solve(int i, int j, int m , int n) {
        if(i == m && j == n) return 1;

        if(storedPaths[i][j] != -1) return storedPaths[i][j];

        int down = (i + 1 <= m) ? solve(i+1, j, m, n) : 0;
        int right = (j + 1 <= n) ? solve(i, j+1, m, n) : 0;

        return storedPaths[i][j] = down + right;
    }
}

/***
down or right
total cell, m*n => 2^(mn)

*/
