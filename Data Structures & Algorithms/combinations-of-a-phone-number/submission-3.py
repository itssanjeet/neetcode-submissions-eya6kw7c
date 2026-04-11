class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        numbers = ['', '', 'abc', 'def', 'ghi', 'jkl', 'mno', 'pqrs', 'tuv', 'wxyz']
        res = []

        def dfs(i, part):
            if i >= len(digits):
                res.append(part[::])
                return

            s = numbers[int(digits[i])]
            
            for c in s:
                dfs(i+1, part + c)

        dfs(0, '')
        return [] if len(digits) == 0 else res
