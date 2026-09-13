class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        ret = []
        self.helper(ret, 0, nums, [])
        return ret
    def helper(self, ret, index, nums, currList):
        if index >= len(nums):
            ret.append(currList[:])
            return
        currList.append(nums[index])
        self.helper(ret, index + 1, nums, currList)
        currList.pop()
        self.helper(ret, index + 1, nums, currList)
        