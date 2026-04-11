class Solution {
    int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    int[][] dp = null;
    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        dp = new int[rows][cols];
        for(int i=0; i<rows; i++){
            Arrays.fill(dp[i], -1);
        }

        int res = 0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                res = Math.max(res, dfs(matrix, i, j, Integer.MIN_VALUE));
            }
        }

        return res;
    }

    private int dfs(int[][] matrix, int r, int c, int pre){
        if(r < 0 || c < 0 || r >= matrix.length || c >= matrix[0].length || matrix[r][c] <= pre){
            return 0;
        }

        if(dp[r][c] != -1){
            return dp[r][c];
        }

        int res = 1;
        for(int[] dir:dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            // if(nr >= 0 && nc >= 0 && nr < matrix.length && nc < matrix[0].length && matrix[nr][nc] > matrix[r][c]){
            res = Math.max(res, 1 + dfs(matrix, nr, nc, matrix[r][c]));
            // }
        }
        
        dp[r][c] = res;
        return res;
    }
}
