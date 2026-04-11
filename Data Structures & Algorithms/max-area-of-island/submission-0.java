class Solution {

    int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    int val = 0;
    public int maxAreaOfIsland(int[][] grid) {
        
        int res = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    val = 0;
                    dfs(grid, i, j);
                    res = Math.max(val, res);
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int r, int c){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length
            || grid[r][c] == 0){
            return;
        }

        grid[r][c] = 0;
        val++;

        for(int[] dir:dirs){
            int nextR = r + dir[0];
            int nextC = c + dir[1];

            // if(nextR >= 0 && nextR < grid.length && nextC >= 0 && nextC < grid[0].length
            //     && grid[nextR][nextC] == 1){
            //         grid[nextR][nextC] == 0;
            dfs(grid, nextR, nextC);
            // }
        }
    }
}
