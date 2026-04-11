class Solution {

    int[][] dirs = {{-1,0}, {1, 0}, {0, -1}, {0, 1}};

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        int max = 0;
        for(int r=0; r<rows; r++){
            for(int c = 0; c<cols; c++){
                if(grid[r][c] == 1){
                    max = Math.max(max, dfs(grid, r, c));
                }
            }
        }

        return max;
    }

    private int dfs(int[][] grid, int r, int c){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0){
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
