class salution:
    def __init__(self,nums):
        self.nums= nums;
    
    def sumOfSquares(self):
        total=0;
        nums=self.nums;
        n=len(nums);
        for e in range(1,n+1):
            if n % e == 0:
                total+=nums[e-1]**2
        
        return total;


dsa=salution([2,7,1,19,18,3]); 
print(dsa.sumOfSquares());
                