class Solution {
    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();

        char[][] grid = new char[n][n];

        for(int r=0; r<n; r++){
            Arrays.fill(grid[r], '.');
        }

        dfs(grid, 0);

        return res;
    }

    private void dfs(char[][] grid, int r ){
        if(r == grid.length){
            List<String> list = new ArrayList<>();
            for(char[] ch:grid){
                list.add(new String(ch));
            }

            res.add(list);
            return;
        }

        for(int c = 0; c < grid.length; c++){
            if(isValid(grid, r, c, grid.length)){
                grid[r][c] = 'Q';
                dfs(grid, r+1);
                grid[r][c] = '.';
            }
        }        
    }

    private boolean isValid(char[][] grid, int r, int c, int n){
        for(int i = 0; i<n; i++){
            if(grid[r][i] == 'Q' || grid[i][c] == 'Q'){
                return false;
            }
        }

        for(int i = r, j = c; i >= 0 && j >= 0; i--, j--){
            if(grid[i][j] == 'Q'){
                return false;
            }
        }

        for(int i=r, j=c; i >= 0 && j<n; i--, j++){
            if(grid[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }
}
