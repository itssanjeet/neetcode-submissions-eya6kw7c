class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return []

        numbers = ['', '', 'abc', 'def', 'ghi', 'jkl', 'mno', 'pqrs', 'tuv', 'wxyz']
        res = ['']

        for d in digits:
            temp = []
            for part in res:
                for c in numbers[int(d)]:
                    temp.append(part + c)

            res = temp

        return res