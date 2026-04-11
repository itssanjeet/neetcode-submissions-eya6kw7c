class Solution {
    int[][] dirs = {{-1,0}, {1, 0}, {0, -1}, {0, 1}};
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visit = new boolean[n][n];

        return dfs(grid, 0, 0, 0, visit);
    }

    private int dfs(int[][] grid, int r, int c, int t, boolean[][] visit){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid.length 
            || visit[r][c]){
                return Integer.MAX_VALUE;
            }

        if(r == grid.length-1 && c == grid.length-1){
            return Math.max(t, grid[r][c]);
        }

        visit[r][c] = true;
        t = Math.max(t, grid[r][c]);
        int res = Integer.MAX_VALUE;
        for(int[] dir:dirs){
            int nr = dir[0] + r;
            int nc = dir[1] + c;

            res = Math.min(res, dfs(grid, nr, nc, t, visit));
        }
        visit[r][c] = false;

        return res;
    }
}
