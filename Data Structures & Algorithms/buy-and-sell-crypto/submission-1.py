class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        m, l, r = 0, 0, 1
        while r < len(prices):
            if prices[r] < prices[l]:
                l = r
            m = max(m, prices[r] - prices[l])
            r += 1
        return m
        