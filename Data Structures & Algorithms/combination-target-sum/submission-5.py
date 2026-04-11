class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        res = []
        nums.sort()
        cur = []

        def dfs(i, total):
            if target == total:
                res.append(cur.copy())
                return

            for j in range(i, len(nums)):
                if total + nums[j] > target:
                    return
                cur.append(nums[j])
                dfs(j, total + nums[j])
                cur.pop()
        
        dfs(0, 0)
        return res