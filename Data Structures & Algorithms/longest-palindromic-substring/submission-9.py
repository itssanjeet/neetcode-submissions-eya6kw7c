class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        if n == 0: return ""
        if n == 1: return s[0]

        res = ''
        resLen = 0

        for i in range(n):
            # odd length
            l = i
            r = i
            while l >= 0 and r < n and s[l] == s[r]:
                if resLen < r-l+1:
                    resLen = r-l+1
                    res = s[l:r+1]
                l,r = l-1, r+1

            # even length
            l = i
            r = i+1
            while l >= 0 and r < n and s[l] == s[r]:
                if resLen < r-l+1:
                    resLen = r-l+1
                    res = s[l:r+1]
                l,r = l-1, r+1


        return res