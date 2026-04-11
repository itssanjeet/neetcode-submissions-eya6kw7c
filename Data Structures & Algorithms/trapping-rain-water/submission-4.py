class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)

        res = 0
        for i in range(1, n-1):
            leftMax = height[i]
            for j in range(i-1, -1, -1):
                leftMax = max(leftMax, height[j])

            rightMax = height[i]
            for j in range(i+1, n):
                rightMax = max(rightMax, height[j])

            res += min(leftMax, rightMax) - height[i]

        return res        