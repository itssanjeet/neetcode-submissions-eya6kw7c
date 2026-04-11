class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [0] * (n+1)
        dp[n-1] = nums[n-1]
        print(dp)
        for i in range(n-2, -1, -1):
            dp[i] = max(dp[i+1], nums[i] + dp[i+2])
        
        return dp[0]

        # def dfs(i):
        #     if i in dp:
        #         return dp[i]

        #     if i >= len(nums):
        #         return 0

        #     dp[i] = max(dfs(i+1), nums[i] + dfs(i+2))
        #     return dp[i]

        # return 0