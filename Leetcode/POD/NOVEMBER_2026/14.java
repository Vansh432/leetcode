class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int result=Integer.MAX_VALUE;
        int n=nums.size();
        for(int i=0;i<=n-l;i++){
            int sum=0;
           for(int j=i;j<n;j++){
                int subSize=j-i+1;
                sum+=nums.get(j);
                if(l<=subSize && subSize<=r && sum>0){
                    result=Math.min(sum,result);
                }
           }
        }
        return result==Integer.MAX_VALUE?-1:result;
    }
}
