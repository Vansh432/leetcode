class Solution:
    def findTheDistanceValue(self, arr1: list[int], arr2: list[int], d: int) -> int:
        count=0
        n=len(arr1)
        m=len(arr2)

        for e in range(0,n):
            check=True
            for s in range(0,m):
                diff=abs(arr1[e]-arr2[s])
                if diff<=d:
                    check=False
                    break
            if check:
                count+=1

        return count