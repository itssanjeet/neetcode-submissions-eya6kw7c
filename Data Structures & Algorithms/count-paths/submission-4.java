class Solution {
    public int uniquePaths(int m, int n) {
        return dfs(m, n, 0, 0);
    }

    private int dfs(int rows, int cols, int r, int c){
        if(r == rows-1 && c == cols-1){
            return 1;
        }

        if(r == rows || c == cols){
            return 0;
        }
        
        return dfs(rows, cols, r+1, c) + dfs(rows, cols, r, c+1);
    }
}
