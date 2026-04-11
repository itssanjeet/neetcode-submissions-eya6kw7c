class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []

        def dfs(open, close, subset):
            if close == open and open == n:
                res.append(subset)
                return

            if open < n:
                dfs(open+1, close, subset + '(')

            if close < open:
                dfs(open, close+1, subset + ')')

        dfs(0,0, '')
        return res;
