class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        
        def dfs(i, target, sum):
            if i == len(nums):
                if target == sum:
                    return 1
                return 0

            return dfs(i+1, target, sum + nums[i]) + dfs(i+1, target, sum - nums[i])

        return dfs(0, target, 0)