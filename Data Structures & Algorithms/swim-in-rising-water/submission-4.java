class Solution {
    public int swimInWater(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        int min = grid[0][0];
        int max = grid[0][0];
        for(int r=0; r<rows; r++){
            for(int c = 0; c<cols; c++){
                min = Math.min(min, grid[r][c]);
                max = Math.max(max, grid[r][c]);
            }
        }

        for(int val = min; val < max; val++){
            if(isValid(grid, 0, 0, val, new boolean[rows][cols])){
                return val;
            }
        }

        return max;
    }

    private boolean isValid(int[][] grid, int r, int c, int val, boolean[][] visited){
        if( r < 0 || c < 0 || r >= grid.length || c >= grid[0].length 
            || grid[r][c] > val || visited[r][c]){
                return false;
        }
        
        if(r == grid.length -1 && c == grid[0].length - 1){
            return true;
        }
        
        visited[r][c] = true;

        boolean res = 
            isValid(grid, r+1, c, val, visited) ||
            isValid(grid, r-1, c, val, visited) ||
            isValid(grid, r, c+1, val, visited) ||
            isValid(grid, r, c-1, val, visited);

        return res;
    }
}
