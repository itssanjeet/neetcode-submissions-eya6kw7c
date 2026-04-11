class Solution {

    public int uniquePaths(int m, int n) {
        return dfs(1, 1, m, n);
    }

    private int dfs(int r, int c, int rows, int cols){
        if(r == rows && c == cols){
            return 1;
        }
        
        if(r > rows || c > cols){
            return 0;
        }

        return dfs(r+1, c, rows, cols) + dfs(r, c+1, rows, cols);
    }
}
