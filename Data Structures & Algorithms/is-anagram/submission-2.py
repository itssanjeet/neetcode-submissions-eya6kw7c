class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if(len(s) != len(t)):
            return False

        arr = {}
        for i in range(len(s)):
            arr[s[i]] = arr.get(s[i], 0) + 1;
            arr[t[i]] = arr.get(t[i], 0) - 1;

        for x in arr.values():
            if x != 0:
                return False

        return True
