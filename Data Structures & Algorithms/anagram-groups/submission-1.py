class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        ret = {}
        for i in range(len(strs)):
            freqArr = [0]*26
            for x in strs[i]:
                freqArr[ord(x)-ord('a')] += 1
            key = tuple(freqArr)
            if key in ret:
                ret[key].append(strs[i])
            else:
                ret[key] = [strs[i]]
        retList = []
        for l in ret.values():
            retList.append(l)
        return retList
