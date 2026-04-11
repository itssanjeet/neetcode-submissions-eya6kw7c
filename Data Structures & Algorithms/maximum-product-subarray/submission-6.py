class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        n = len(nums)

        leftProd = 1
        rightProd = 1
        res = nums[0]

        for i in range(n):
            if leftProd == 0:
                leftProd = 1
            
            if rightProd == 0:
                rightProd = 1
            leftProd *= nums[i]
            rightProd *= nums[n-i-1]
            res = max(res, leftProd, rightProd)

        return res