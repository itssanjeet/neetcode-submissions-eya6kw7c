class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        
        res = []
        subset = []

        def solve(i):
            res.append(subset[::])

            for j in range(i, len(nums)):
                if j>i and nums[j] == nums[j-1]:
                    continue

                subset.append(nums[j])
                solve(j+1)
                subset.pop()

        nums.sort()
        solve(0)
        return res