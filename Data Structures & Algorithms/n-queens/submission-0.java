class Solution {
    

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        char[][] grid = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                grid[i][j] = '.';
            }
        }

        dfs(grid, 0, res);
        return res;
    }

    private void dfs(char[][] grid, int r, List<List<String>> res){
        if(r==grid.length){
            List<String> res1 = new ArrayList<>();
            for(char[] row:grid){
                res1.add(new String(row));
            }
            res.add(res1);

            return;
        }

        for(int i=0; i<grid.length; i++){
            if(isSafe(grid, r, i)){
                grid[r][i] = 'Q';
                dfs(grid, r+1, res);
                grid[r][i] = '.';
            }
        }
    }

    private boolean isSafe(char[][] grid, int r, int c){
        
        for(int i=r-1; i >= 0; i--){
            if(grid[i][c] == 'Q'){
                return false;
            }
        }

        for(int i=r-1, j=c-1; i>=0 && j>=0; i--, j--){
            if(grid[i][j] == 'Q'){
                return false;
            }
        }

        for(int i=r-1, j=c+1; i>=0 && j<grid.length; i--, j++){
            if(grid[i][j] == 'Q')
                return false;
        }

        return true;
    }
}
