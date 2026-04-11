class Solution {

    int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public int maxAreaOfIsland(int[][] grid) {
        
        int res = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    res = Math.max(dfs(grid, i, j), res);
                }
            }
        }

        return res;
    }

    private int dfs(int[][] grid, int r, int c){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length
            || grid[r][c] == 0){
            return 0;
        }

        grid[r][c] = 0;
        int res = 1;

        for(int[] dir:dirs){
            res += dfs(grid, r + dir[0], c + dir[1]);
        }

        return res;
    }
}
