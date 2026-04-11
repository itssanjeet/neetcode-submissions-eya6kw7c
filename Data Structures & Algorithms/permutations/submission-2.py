class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        
        res = []

        def dfs(i):
            if i == len(nums):
                res.append(nums.copy())
                return

            def swap(i,j):
                t = nums[i]
                nums[i] = nums[j]
                nums[j] = t

            for j in range(i, len(nums)):
                swap(i,j)
                dfs(i+1)
                swap(i,j)
            
        dfs(0)
        return res
