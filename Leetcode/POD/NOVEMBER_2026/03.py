class Solution:
    def minMoves(self, nums: List[int]) -> int:
        maxEle=0
        n=len(nums)
        for e in range(0,n):
            maxEle=max(nums[e],maxEle)
        moves=0

        for e in range(0,n):
            moves+=maxEle-nums[e]
        return moves    

        