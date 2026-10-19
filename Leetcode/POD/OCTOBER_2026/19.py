class Solution:
    def targetIndices(self, nums: list[int], target: int) -> list[int]:
        count_less=0
        count_greater=0
        n=len(nums)
        for i in range(0,n):
            if nums[i]<target:
                count_less+=1
            elif nums[i]>target:
                count_greater+=1

        count_target=n-count_greater-count_less
        ans=[]
        for i in range(0,count_target):
            ans.append(i+count_less)

        return ans    

        