class Solution {
    int[][] dirs = {{-1,0}, {1,0}, {0, -1}, {0,1}};
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();

        for(int r=0; r<grid.length; r++){
            for(int c=0; c<grid[0].length; c++){
                if(grid[r][c] == 0){
                    q.add(new int[]{r,c});
                }
            }
        }

        int count = 1;
        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){
                int[] node = q.poll();
                int r = node[0];
                int c = node[1];
                // grid[r][c] = count;

                for(int[] dir:dirs){
                    int nr = r + dir[0];
                    int cr = c + dir[1];
                    if(nr >= 0 && cr >= 0 && nr < grid.length && cr < grid[0].length && grid[nr][cr] == Integer.MAX_VALUE){
                        grid[nr][cr] = count;
                        q.add(new int[]{nr, cr});
                    }
                }
            }
            count++;
        }
    }
}
