class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        rows = len(matrix)
        cols = len(matrix[0])

        dirs = [[-1,0], [1, 0], [0, -1], [0, 1]]

        def dfs(i, j, pre):
            if i < 0 or j < 0 or i == rows or j == cols or pre >= matrix[i][j]:
                return 0

            res = 0
            for dir in dirs:
                res = max(res, 1 + dfs(i+dir[0], j + dir[1], matrix[i][j]))

            return res

        res = 0
        for i in range(rows):
            for j in range(cols):
                res = max(res, dfs(i, j, -1))

        return res
