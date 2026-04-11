class Solution {
    
    int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0, 1}};
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        for(int r=0; r<grid.length; r++){
            for(int c=0; c<grid[0].length; c++){
                if(grid[r][c] == 0){
                    //Store in queue
                    queue.add(new int[]{r,c});
                }
            }
        }

        int res = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int[] pair = queue.poll();
                int r = pair[0];
                int c = pair[1];
                // grid[r][c] = res;

                for(int[] dir:dirs){
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if(isValid(grid, nr, nc)){
                        grid[nr][nc] = res;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }

            res++;
        }
    }

    private boolean isValid(int[][] grid, int r, int c){
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 2147483647;
    }
}
