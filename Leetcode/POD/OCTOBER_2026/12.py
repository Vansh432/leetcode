class Solution:
    def maxAlternatingSum(self, nums: List[int]) -> int:
        n=len(nums)
        for e in range(0,n):
            nums[e]=nums[e] ** 2
        nums.sort()
        i=0
        j=n-1
        total=0
        while i<j:
            total+=nums[j]-nums[i]
            i+=1
            j-=1
        return total if n%2==0 else total + nums[j] 



        