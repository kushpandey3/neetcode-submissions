class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        ret = 0
        for x in nums:
            ret ^= x
        return ret