class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        m, l = 0, 0
        for r in range(0, len(prices)):
            if prices[r] < prices[l]:
                l = r
            prof = prices[r] - prices[l]
            if prof > m:
                m = prof
        return m
        