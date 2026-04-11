class Solution {

    int[][] dirs = {{0,-1}, {0,1}, {-1,0}, {1,0}};
    public int numIslands(char[][] grid) {
        int res = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    res++;
                    bfs(grid, i, j);
                }
            }
        }

        return res;
    }

    private void bfs(char[][] grid, int r, int c){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});

        while(!queue.isEmpty()){
            int[] d = queue.poll();

            for(int[] dir:dirs){
                int nextR = d[0] + dir[0];
                int nextC = d[1] + dir[1];

                if(nextR >= 0 && nextR < grid.length && nextC >= 0 && nextC < grid[0].length 
                    && grid[nextR][nextC] == '1'){
                        grid[nextR][nextC] = '0';
                        queue.add(new int[]{nextR, nextC});
                }
            }
        }
    }
}
