class Solution {

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int orangesRotting(int[][] grid) {
        int row = grid.length, col = grid[0].length;

        int res = 0, fresh = 0;

        Queue<int[]> queue = new LinkedList<>();
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                if(grid[r][c] == 1){
                    fresh++;
                }
                if(grid[r][c] == 2){
                    queue.add(new int[]{r, c});
                }
            }
        }

        while(fresh > 0 && !queue.isEmpty()){
            int size = queue.size();

            for(int i=1; i<=size; i++){
                int[] coordinate = queue.poll();

                int r = coordinate[0];
                int c = coordinate[1];

                for(int[] dir:dirs){
                    int nextR = r + dir[0];
                    int nextC = c + dir[1];
                    if(isValid(grid, nextR, nextC)){
                        fresh--;
                        grid[nextR][nextC] = 2;
                        queue.add(new int[]{nextR, nextC});
                    }
                }
            }

            res++;
        }

        return fresh == 0? res:-1;
    }

    private boolean isValid(int[][] grid, int r, int c){
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length 
            && grid[r][c] == 1;
    }
}
