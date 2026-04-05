class Solution {
    int dirX[] = {1,-1,0,0};
    int dirY[] = {0,0,1,-1};
    public boolean exist(char[][] board, String word) {
        boolean vis[][] = new boolean[board.length][board[0].length];

        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++) {
                if(board[i][j] == word.charAt(0)) {
                    vis = new boolean[board.length][board[0].length];
                    if(solve(i,j,0,board, word, vis) == true) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean solve(int i, int j, int index, char arr[][],  String str, boolean vis[][]) {
        if(index == str.length()) return true;
        if(index == str.length()-1 && str.charAt(index) == arr[i][j]) return true;
        // System.out.println("solve("+i+", j="+j+", word_index="+index+")");
        vis[i][j] = true;

        if(arr[i][j] == str.charAt(index)) { // match, check next 
            for(int k=0;k<4;k++) {
                int newI = i + dirX[k];
                int newJ = j + dirY[k];
                // System.out.println("\t new_i="+newI+", new_j="+newJ+", word_index="+index+", isValid : "+isValid(newI, newJ, vis, arr));
                if(isValid(newI, newJ, vis, arr)) {
                    if(solve(newI, newJ, index+1, arr, str, vis)) return true;
                }
            }
        }
        vis[i][j] = false;
        return false;
    }

    private boolean isValid(int i, int j, boolean vis[][], char arr[][]) {
        if(i >= 0 && i < arr.length && j >= 0 && j < arr[0].length && vis[i][j] == false) {
            return true;
        }
        return false;
    }
}

/*
standing at a cell i,j, we can match with current character of word at index k
if it is matched => check next character at k+1, in four directions. 
while navigating, do not visit the visited cell.

*/
