class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        prefix, suffix, ret = [0]*len(nums), [0]*len(nums), [0]*len(nums)
        prefix[0] = 1
        suffix[-1] = 1
        for i in range(1, len(nums)):
            prefix[i] = prefix[i-1]*nums[i-1]
            suffix[-(i+1)] = suffix[-i]*nums[-i]
        ret[0], ret[-1] = suffix[0], prefix[-1]
        for i in range(1, len(nums) - 1):
            ret[i] = prefix[i]*suffix[i]
        return ret

        
        
        