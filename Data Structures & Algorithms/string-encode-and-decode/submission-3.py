class Solution:

    def encode(self, strs: List[str]) -> str:
        ret = ""
        for x in strs: 
            ret = f"{ret}{len(x)}#{x}"
        return ret
    def decode(self, s: str) -> List[str]:
        ret = []
        currIndex = 0
        while currIndex < len(s):
            startIndex = s.find('#', currIndex)
            length = int(s[currIndex:startIndex])
            ret.append(s[startIndex+1:startIndex+1+length])
            currIndex = startIndex + 1 + length
        return ret
