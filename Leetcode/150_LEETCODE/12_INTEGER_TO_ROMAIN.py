class Solution:
    def intToRoman(self, num: int) -> str:
        romanPossible=["M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"];
        values=[1000,900,500,400,100,90,50,40,10,9,5,4,1];
        n=len(values)
        result=""
        for e in range(n):
            while num>=values[e]:
                num-=values[e]
                result+=romanPossible[e]
        return result        
        