class Solution:
    def sortPermutation(self, nums: List[int]) -> int:
        ans=-1
        n=len(nums)
        for e in range(0,n):
            if nums[e] != e:
                ans=ans & nums[e]
        return max(ans,0)    