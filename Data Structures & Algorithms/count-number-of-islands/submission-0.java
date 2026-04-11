class Solution {

    int[][] dirs = {{0,-1}, {0,1}, {-1,0}, {1,0}};
    public int numIslands(char[][] grid) {
        
        int res = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    res++;
                    dfs(grid, i, j);
                }
            }
        }

        return res;
    }

    private void dfs(char[][] grid, int row, int col){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length 
            || grid[row][col] != '1'){
            return;
        }

        grid[row][col] = '2';

        for(int[] dir:dirs){
            int nextR = row + dir[0];
            int nextC = col + dir[1];

            dfs(grid, nextR, nextC);
        }
    }
}
