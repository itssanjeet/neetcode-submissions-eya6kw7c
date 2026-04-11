class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 0: return 0
        if n == 1: return nums[0]

        def helper(num):
            n = len(num)
            one, two = num[n-1], 0
            for i in range(n-2, -1, -1):
                three = max(one, two + num[i])
                two = one
                one = three
            return one

        return max(helper(nums[1:]), helper(nums[:len(nums)-1]))

