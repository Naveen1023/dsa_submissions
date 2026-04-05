class NumMatrix {
    int arr[][];
    public NumMatrix(int[][] matrix) {
        arr = new int[matrix.length][matrix[0].length];

        //calculcate row wise sum
        for(int row=0;row<matrix.length;row++) {
            int sum = 0 ;
            int col = 0;
            while(col < matrix[0].length) {
                sum += matrix[row][col];
                arr[row][col] = sum;
                col++;
            }
        }

        // for(int a[] : arr) {
        //     System.out.println(Arrays.toString(a));
        // }
        // System.out.println();

        // calculate col wise in same matrix now
        for(int col=0;col<arr[0].length;col++) {
            int row =0;
            int sum =0;
            while(row < arr.length) {
                sum += arr[row][col];
                arr[row][col] = sum;
                row++;
            }
        }

        // for(int a[] : arr) {
        //     System.out.println(Arrays.toString(a));
        // }
        // System.out.println();
    }
    
    public int sumRegion(int r1, int c1, int r2, int c2) {

        // System.out.println("r1,c1,r2,c2 respectively : "+r1+", "+c1+", "+r2+", "+c2);

        // System.out.println(arr[r2][c2]+" - "+safeSubtract(arr, r1-1,c2)+" - "+safeSubtract(arr, r2,c1-1)+" + "+safeAdd(arr, r1-1,c1-1));
        return arr[r2][c2] - safeSubtract(arr, r1-1,c2)
                           - safeSubtract(arr, r2,c1-1)
                           + safeAdd(arr, r1-1,c1-1);
    }

    private int safeSubtract(int arr[][], int row, int col) {
        if(row >= 0 && col >= 0 ) {
            return arr[row][col];
        }
        return 0;
    }

        private int safeAdd(int arr[][], int row, int col) {
        if(row >= 0 && col >= 0) {
            return arr[row][col];
        }
        return 0;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

 /**
[3, 3, 4, 8,    10]
[8, 14, 18, 24, 27]
[9, *17, 21, 28, 36]
[13, 22, 26, 34, 49]
[14, 23, 30, 38*, 58]



(r1 = 2, c1 = 1)
(r2 = 4, c2 = 3)
 
arr[r2][c2] - arr[r1-1][c2] - arr[r2][c1-1] + arr[r1-1][c1-1]
  */