class Solution {
    int[][] dirs = {{-1,0}, {1, 0}, {0, -1}, {0, 1}};
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        
        int min_val = Integer.MAX_VALUE, max_val = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                min_val = Math.min(min_val, grid[i][j]);
                max_val = Math.max(max_val, grid[i][j]);
            }
        }
        
        for(int t=min_val; t<max_val; t++){
            if(dfs(grid, 0, 0, t, new boolean[n][n])){
                return t;
            }
        }

        return max_val;
    }

    private boolean dfs(int[][] grid, int r, int c, int t, boolean[][] visit){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid.length
             || grid[r][c] > t || visit[r][c]){
            return false;
        }

        if(r == grid.length-1 && c == grid.length -1){
            return true;
        }
        visit[r][c] = true;

        boolean res = 
            dfs(grid, r+1, c, t, visit) ||
            dfs(grid, r-1, c, t, visit) ||
            dfs(grid, r, c+1, t, visit) ||
            dfs(grid, r, c-1, t, visit);
        
        return res;
    }
}
