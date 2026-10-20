class Solution {
    private static boolean isRotatedSortedArray(int[] arr,int start,int end){
        int breakPoint=0;
  
        for(int i=start+1;i<=end;i++){
            if(arr[i-1]>arr[i]){
                breakPoint++;
            }
            if(breakPoint>1)return false;
        }
        if(breakPoint==1 && arr[start]<arr[end]) return false;
        return true;
    }
    public int sortableIntegers(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i=1;i<=n/2;i++){
            if(n%i==0){
                int prev=0;
                int min=Integer.MAX_VALUE;
                int max=Integer.MIN_VALUE;
                boolean check=true;
                int count=0;
                for(int j=0;j<n;j++){
                    count++;
                    if(count==i){
                        min=Math.min(min,nums[j]);
                        if(i>2 && !isRotatedSortedArray(nums,j-i+1,j)){
                          check=false;
                          break;
                        }
                        if(prev>min){
                         check=false;
                          break;
                        }
                        max=Math.max(max,nums[j]);
                        prev=max;
                        min=Integer.MAX_VALUE;
                        count=0;
                        continue;
                    }
                     min=Math.min(min,nums[j]);
                     max=Math.max(max,nums[j]);
                }
                if(check)sum+=i;
            }
        }
        if(isRotatedSortedArray(nums,0,n-1))sum+=n;
        return sum;
    }
}