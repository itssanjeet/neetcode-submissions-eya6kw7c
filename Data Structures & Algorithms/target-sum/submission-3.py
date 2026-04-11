class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        dp={}

        def dfs(i, target, sum):
            if i == len(nums):
                if target == sum:
                    return 1
                return 0

            if (i, sum) in dp:
                return dp[(i, sum)]

            dp[(i, sum)] = dfs(i+1, target, sum + nums[i]) + dfs(i+1, target, sum - nums[i])
            return dp[(i, sum)]

        return dfs(0, target, 0)