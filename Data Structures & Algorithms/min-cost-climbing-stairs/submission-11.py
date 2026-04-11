class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        n = len(cost)
        one, two = cost[n-1], cost[n-2]

        for i in range(len(cost)-3, -1, -1):
            three = cost[i] + min(one, two)
            one = two
            two = three

        return min(one, two)