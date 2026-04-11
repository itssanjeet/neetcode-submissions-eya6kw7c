class Solution:
    def isPali(self, i,j, s):
            while i < j:
                if s[i] != s[j]:
                    return False
                i,j = i+1, j-1
            return True

    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        if n == 0: return ""
        if n == 1: return s[0]

        res = s[0]
        resLen = 1

        for i in range(n):
            for j in range(i+1, n):
                if self.isPali(i,j, s) and j-i+1 > resLen:
                    resLen = j-i+1
                    res = s[i:j+1]

        

        return res