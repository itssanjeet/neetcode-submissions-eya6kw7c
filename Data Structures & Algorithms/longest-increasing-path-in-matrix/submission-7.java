class Solution {

    int[][] dirs = {{-1,0}, {1,0}, {0, -1}, {0, 1}};
    public int longestIncreasingPath(int[][] matrix) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int max = 0;
        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                boolean[][] visited = new boolean[rows][cols];
                max = Math.max(max, solve(matrix, r, c, Integer.MIN_VALUE));
            }
        }

        return max;
    }

    private int solve(int[][] matrix, int r, int c, int pre){
        if(r < 0 || c < 0 || r >= matrix.length || c >= matrix[0].length 
            || pre >= matrix[r][c]){
            return 0;
        }

        int res = 1;
        for(int[] dir: dirs){
            int nr = dir[0] + r;
            int nc = dir[1] + c;

            res = Math.max(res, 1 + solve(matrix, r + dir[0], c + dir[1], matrix[r][c]));
        }

        return res;
    }
}
