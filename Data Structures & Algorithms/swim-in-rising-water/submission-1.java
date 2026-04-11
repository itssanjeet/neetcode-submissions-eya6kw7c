class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            for(int j=0; j<n; j++){
                minVal = Math.min(minVal, grid[i][j]);
                maxVal = Math.max(maxVal, grid[i][j]);
            }
        }

        // boolean[][] visit = new boolean[n][n];
        for(int t=minVal; t<maxVal; t++){
            if(dfs(grid, 0, 0, t, new boolean[n][n])){
                return t;   
            }

            // for(int i=0; i<n; i++){
            //     Arrays.fill(visit[i], false);
            // }
        }

        return maxVal;
    }

    private boolean dfs(int[][] grid, int r, int c,int t, boolean[][] visit){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid.length || visit[r][c] || 
            grid[r][c] > t){
                return false;
            }

        if(r == grid.length-1 && c == grid.length-1){
            return true;
        }
        
        visit[r][c] = true;
        boolean res =
            dfs(grid, r+1, c, t ,visit) ||
            dfs(grid, r-1, c, t ,visit) ||
            dfs(grid, r, c+1, t,visit) ||
            dfs(grid, r, c-1, t ,visit);
        
        return res;
    }
}
