class Solution {

    Set<Integer> cols = new HashSet<>();
    Set<Integer> posCels = new HashSet<>();
    Set<Integer> negCels = new HashSet<>();

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

    // private void dfs(char[][] grid, int r, List<List<String>> res){
    //     if(r == grid.length){
    //         List<String> res1 = new ArrayList<>();
    //         for(char[] ch:grid){
    //             res1.add(new String(ch));
    //         }
    //         res.add(res1);

    //         return;
    //     }

    //     for(int i=0; i<grid.length; i++){
    //         if(cols.contains(i) || negCels.contains(r-i) || posCels.contains(r+i)){
    //             continue;
    //         }

    //         cols.add(i);
    //         negCels.add(r-i);
    //         posCels.add(r+i);
    //         grid[r][i] = 'Q';

    //         dfs(grid, r+1, res);

    //         cols.remove(i);
    //         negCels.remove(r-i);
    //         posCels.remove(r+i);
    //         grid[r][i] = '.';
    //     }
    // }

    private void dfs(char[][] grid, int r, List<List<String>> res){
        System.out.println("dfs called");
        if(r == grid.length){
            List<String> res1 = new ArrayList<>();
            for(char[] row:grid){
                res1.add(new String(row));
            }
            res.add(res1);

            return;
        }
        
        for(int i=0; i<grid.length; i++){
            if(cols.contains(i) || posCels.contains(r+i) || negCels.contains(r-i)){
                continue;
            }

            cols.add(i);
            posCels.add(r+i);
            negCels.add(r-i);
            grid[r][i] = 'Q';

            dfs(grid, r+1, res);

            cols.remove(i);
            posCels.remove(r+i);
            negCels.remove(r-i);
            grid[r][i] = '.';
        }
    }
}
