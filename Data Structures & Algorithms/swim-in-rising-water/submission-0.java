class Solution {
    int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public int swimInWater(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];    
        
        return dfs(grid, 0, 0, 0, visited);

    }

    private int dfs(int[][] grid, int r, int c, int t, boolean[][] visited){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || visited[r][c]){
            return 1000000;
        }

        if(r == grid.length-1 && c == grid[0].length-1){
            return Math.max(t, grid[r][c]);
        }

        visited[r][c] = true;
        t = Math.max(t, grid[r][c]);
        int res = Integer.MAX_VALUE;
        for(int[] dir:dirs){
            res = Math.min(res, dfs(grid, r + dir[0], c + dir[1], t, visited));
        }
        
        visited[r][c] = false;
        return res;
    }
}
