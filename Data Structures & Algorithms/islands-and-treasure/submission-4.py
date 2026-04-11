class Solution:
    def isValid(self, r,c, rows, cols):
        return r >= 0 and c >=0 and r  < rows and c < cols


    def islandsAndTreasure(self, grid: List[List[int]]) -> None:
        rows, cols = len(grid), len(grid[0])
        dirs = [[-1,0], [1,0], [0,-1], [0,1]]
        visit = set()

        q = []
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 0:
                    q.append((r,c))
                    visit.add((r,c))

        count = 0
        while len(q) > 0:
            size = len(q)
            for i in range(size):
                r,c = q.pop(0)
                grid[r][c] = count
                for dir in dirs:
                    nr = r + dir[0]
                    nc = c + dir[1]
                    if self.isValid(nr,nc, rows, cols) and grid[nr][nc] != -1 and (nr, nc) not in visit:
                        q.append((nr,nc))
                        visit.add((nr,nc))

            count += 1





