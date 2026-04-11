class Solution {
    
    int[][] dirs = {{-1,0}, {1, 0}, {0, -1}, {0, 1}};

    public int longestIncreasingPath(int[][] matrix) {

        int res = 0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                res = Math.max(res, dfs(matrix, i, j));
            }
        }

        return res;
    }

    private int dfs(int[][] matrix, int i, int j){
        
        int res = 1;
        for(int[] dir:dirs){
            int ni = dir[0] + i;
            int nj = dir[1] + j;
            if(ni >= 0 && ni < matrix.length && nj >= 0 && nj < matrix[0].length && matrix[i][j] < matrix[ni][nj]){
                res = Math.max(res, 1 + dfs(matrix, ni, nj));
            }
        }

        return res;
    }
}
