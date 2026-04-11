class Solution:
    def climbStairs(self, n: int) -> int:
        memo = {}
        memo[0] = 1

        def dfs(i):
            if i in memo:
                return memo[i]

            if i < 0:
                return 0

            memo[i] = dfs(i-1) + dfs(i-2)
            return memo[i]

        return dfs(n)


