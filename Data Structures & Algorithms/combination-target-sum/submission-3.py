class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        nums.sort()
        res = []
        sub = []

        def solve(i, sum):
            if target == sum:
                res.append(sub.copy())
                return

            if i == len(nums) or sum > target:
                return

            if nums[i] + sum <= target:
                sub.append(nums[i])
                solve(i, sum + nums[i])
                sub.pop()
                solve(i+1, sum)
            
        solve(0, 0)
        return res



