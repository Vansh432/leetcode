class Solution {
    private static int costCalce(int x,int j,int i){
        int result=x+(int)Math.pow((j-i),2);
        return result;
    }
    public int climbStairs(int n, int[] cost) {
        int[] dp=new int[n+1];
        int j=1;
        for(int i=1;i<=n;i++){
            if(i==1){
              int costValue=costCalce(cost[j-1],j,i-1);
              dp[i]=costValue;
            
            }else if(i==2){
              int costValueOne=costCalce(cost[j-1],j,i-1);
              int costValueTwo=costCalce(cost[j-1],j,i-2);
              dp[i]=Math.min(costValueOne+dp[i-1],costValueTwo+dp[i-2]);
            }else{
              int costValueOne=costCalce(cost[j-1],j,i-1);
              int costValueTwo=costCalce(cost[j-1],j,i-2);
              int costValueThree=costCalce(cost[j-1],j,i-3);
              int firstCheck=Math.min(costValueOne+dp[i-1],costValueTwo+dp[i-2]);
              dp[i]=Math.min(costValueThree+dp[i-3],firstCheck);
            }
              ++j;
        }
        return dp[n];
    }
}