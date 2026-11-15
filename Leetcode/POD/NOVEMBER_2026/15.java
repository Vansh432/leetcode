class Solution {
    private static int MOD=1000000007;
    public int numOfSubarrays(int[] arr) {
        int even=1;
        int odd=0;
        int ans=0;
        int prefix=0;
        for(int e:arr){
            prefix +=e;
            if(prefix%2!=0){
              ans+=even;
              odd++;
            }else{
               ans+=odd;
               even++;
            }
            ans%=MOD;
        }
        return (int)ans;
    }
}
