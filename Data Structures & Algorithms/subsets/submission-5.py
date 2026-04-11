class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        res = [[]]
        
        for n in nums:
            size = len(res)
            for i in range(size):
                subset = res[i].copy()
                subset.append(n)
                res.append(subset)

        return res
        