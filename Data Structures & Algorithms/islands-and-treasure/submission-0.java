class Solution {
    public void islandsAndTreasure(int[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int r = 0; r<n; r++){
            for(int c = 0; c < m; c++){
                if(grid[r][c] == 0){
                    queue.add(new int[]{r,c});
                }
            }
        }

        int val = 1;
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=1; i <= size; i++){
                int[] level = queue.poll();
                int r = level[0];
                int c = level[1];

                visitCells(grid, r+1, c, queue, val);
                visitCells(grid, r-1, c, queue, val);
                visitCells(grid, r, c+1, queue, val);
                visitCells(grid, r, c-1, queue, val);
            }

            val++;
        }
    }

    private void visitCells(int[][] grid, int r, int c, Queue<int[]> queue, int val){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length 
            || grid[r][c] == -1 || grid[r][c] != Integer.MAX_VALUE){
                return;
        }

        grid[r][c] = val;
        queue.add(new int[]{r,c});
    }
}
