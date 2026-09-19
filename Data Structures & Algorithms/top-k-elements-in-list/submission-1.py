class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freqs = {}
        for x in nums:
            if x in freqs:
                freqs[x] += 1
            else:
                freqs[x] = 1
        bucketSort = [[] for _ in range(len(nums))]
        for x in freqs:
            bucketSort[freqs[x]-1].append(x)
        ret, filledOut = [0]*k, 0
        for x in range (len(bucketSort)-1, -1, -1):
            for val in bucketSort[x]:
                ret[filledOut] = val
                filledOut += 1
                if filledOut>=k:
                    return ret
        return ret
