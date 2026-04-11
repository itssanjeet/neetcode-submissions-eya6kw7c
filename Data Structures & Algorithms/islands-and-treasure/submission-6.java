class Solution {

    int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                if(grid[r][c] == 0){
                    q.add(new int[]{r,c});
                }
            }
        }

        int res = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] crr = q.poll();

                int r = crr[0];
                int c = crr[1];

                for(int[] dir:dirs){
                    int nr = dir[0] + r;
                    int nc = dir[1] + c;

                    if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == Integer.MAX_VALUE){
                        grid[nr][nc] = res;
                        q.add(new int[]{nr, nc});
                    }
                }
            }

            res++;
        }
    }
}
