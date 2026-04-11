class Solution {

    int[][] memo = null;

    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(memo[i], -1);
        }
        memo[m-1][n-1] = 1;

        return dfs(0, 0, m, n);
    }

    private int dfs(int r, int c, int rows, int cols){
        if(r >= rows || c >= cols){
            return 0;
        }
        // if(r == rows-1 && c == cols-1){
        //     return 1;
        // }
        if(memo[r][c] != -1){
            return memo[r][c];
        }

        memo[r][c] = dfs(r+1, c, rows, cols) + dfs(r, c+1, rows, cols);

        return memo[r][c];
    }
}
