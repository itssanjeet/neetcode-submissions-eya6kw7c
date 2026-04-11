class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        rows = len(matrix)
        cols = len(matrix[0])

        dirs = [[-1,0], [1, 0], [0, -1], [0, 1]]
        memo = {}

        def dfs(i, j, pre):
            if i < 0 or j < 0 or i == rows or j == cols or pre >= matrix[i][j]:
                return 0

            if (i,j) in memo:
                return memo[(i,j)]

            res = 1
            res = max(res, 1+ dfs(i+1, j, matrix[i][j]))
            res = max(res, 1+ dfs(i-1, j, matrix[i][j]))
            res = max(res, 1+ dfs(i, j+1, matrix[i][j]))
            res = max(res, 1+ dfs(i, j-1, matrix[i][j]))

            memo[(i, j)] = res
            return res

        LIS = 0
        for i in range(rows):
            for j in range(cols):
                LIS = max(LIS, dfs(i, j, -1))

        return LIS
