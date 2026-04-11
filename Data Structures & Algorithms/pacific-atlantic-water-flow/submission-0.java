class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];

        for(int c = 0; c < cols; c++){
            dfs(heights, 0, c, heights[0][c], pac);
            dfs(heights, rows-1, c, heights[rows-1][c], atl);
        }

        for(int r = 0; r < rows; r++){
            dfs(heights, r, 0, heights[r][0], pac);
            dfs(heights, r, cols-1, heights[r][cols-1], atl);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int r=0; r<rows; r++){
            for(int c = 0; c<cols; c++){
                if(pac[r][c] && atl[r][c]){
                    List<Integer> res1 = new ArrayList<>();
                    res1.add(r); res1.add(c);
                    res.add(res1);
                }
            }
        }

        return res;
    }

    private void dfs(int[][] heights, int r, int c, int preHeight, boolean[][] ocean){
        if(r < 0 || r >= heights.length || c < 0 || c >= heights[0].length ||
        preHeight > heights[r][c] || ocean[r][c]){
            return;
        }

        ocean[r][c] = true;
        dfs(heights, r+1, c, heights[r][c] , ocean);
        dfs(heights, r-1, c, heights[r][c] , ocean);
        dfs(heights, r, c+1, heights[r][c], ocean);
        dfs(heights, r, c-1, heights[r][c], ocean);
    }
}
