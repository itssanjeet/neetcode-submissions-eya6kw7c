class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0,-1}, {0, 1}};
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int r=0; r<grid.length; r++){
            for(int c=0; c<grid[0].length; c++){
                if(grid[r][c] == 1){
                    fresh++;
                } else if(grid[r][c] == 2){
                    q.add(new int[]{r,c});
                }
            }
        }

        int res = 0;
        while(fresh > 0 && !q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){
                int[] node = q.poll();
                int r = node[0];
                int c = node[1];
                for(int[] dir:dirs){
                    int nr = r + dir[0];
                    int cr = c + dir[1];
                    if(nr >= 0 && cr >= 0 && nr < grid.length && cr < grid[0].length && grid[nr][cr] == 1){
                        grid[nr][cr] = 2;
                        fresh--;
                        q.add(new int[]{nr, cr});
                    }
                }
            }

            res++;
        }

        return fresh == 0? res: -1;
    }
}
