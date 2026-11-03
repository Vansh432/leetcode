class Solution {
    public int minMoves(int[] nums) {
       int min=Integer.MAX_VALUE;
       long sum=0;
       for(int e:nums){
          sum+=e;
          min=Math.min(min,e);
       }
       return (int) (sum - (long) nums.length * min);
    }
}