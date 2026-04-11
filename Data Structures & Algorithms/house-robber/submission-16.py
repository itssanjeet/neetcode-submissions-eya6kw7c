class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        one, two = 0, nums[n-1]

        for i in range(n-2, -1, -1):
            three = max(two, one + nums[i])
            one = two
            two = three

        return two