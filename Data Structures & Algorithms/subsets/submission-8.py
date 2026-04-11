class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        n = len(nums)
        res = [[]]
        for x in nums:
            size = len(res)
            for i in range(size):
                subset = res[i].copy()
                subset.append(x)
                res.append(subset)

        return res