class Solution:
    def islandsAndTreasure(self, grid: List[List[int]]) -> None:
        rows, cols = len(grid), len(grid[0])
        q = deque()
        visit = set()

        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 0:
                    q.append((r,c))
                    visit.add((r,c))
                
        def addValidCell(r,c):
            if r >= 0 and c >= 0 and r < rows and c < cols and grid[r][c] !=-1 and (r,c) not in visit:
                q.append((r,c))
                visit.add((r,c))

        count = 0
        while q:
            size = len(q)
            for i in range(size):
                r,c = q.popleft()
                grid[r][c] = count

                addValidCell(r-1,c)
                addValidCell(r+1,c)
                addValidCell(r,c-1)
                addValidCell(r,c+1)

            count += 1
