class Solution:
    def isValid(self, r, c, rows, cols):
        if r >= 0 and  c>=0 and r < rows and c < cols:
            return True
        return False

    def orangesRotting(self, grid: List[List[int]]) -> int:
        rows,cols = len(grid), len(grid[0])
        q = deque()
        dirs = [[-1,0], [1,0], [0,1], [0,-1]]
        
        fresh = 0
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 2:
                    q.append((r,c))
                if grid[r][c] == 1:
                    fresh +=1
        
        res = 0
        while fresh > 0 and q:
            size = len(q)

            for i in range(size):
                r,c = q.popleft()

                for dir in dirs:
                    nr = r + dir[0]
                    nc = c + dir[1]
                    if self.isValid(nr, nc, rows, cols) and grid[nr][nc] == 1:
                        fresh -=1
                        grid[nr][nc] = 2
                        q.append((nr,nc))

            res += 1
        return res if fresh == 0 else -1

