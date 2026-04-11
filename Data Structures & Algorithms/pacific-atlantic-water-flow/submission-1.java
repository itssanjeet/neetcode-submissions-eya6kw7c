class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pac = new boolean[n][m];
        boolean[][] atl = new boolean[n][m];

        for(int c = 0; c<m; c++){
            dfs(heights, 0, c, pac, heights[0][c]);
            dfs(heights, n-1, c, atl, heights[n-1][c]);
        }

        for(int r=0; r<n; r++){
            dfs(heights, r, 0, pac, heights[r][0]);
            dfs(heights, r, m-1, atl, heights[r][m-1]);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                if(pac[r][c] && atl[r][c]){
                    List<Integer> list = new ArrayList<>();
                    list.add(r);
                    list.add(c);
                    res.add(list);
                }
            }
        }

        return res;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] ocean, int preHeight){
        if(r < 0 || c < 0 || r >= heights.length || c >= heights[0].length 
            || preHeight > heights[r][c] || ocean[r][c]){
                return;
        }

        ocean[r][c] = true;

        dfs(heights, r-1, c, ocean, heights[r][c]);
        dfs(heights, r+1, c, ocean, heights[r][c]);
        dfs(heights, r, c-1, ocean, heights[r][c]);
        dfs(heights, r, c+1, ocean, heights[r][c]);
    }
}
