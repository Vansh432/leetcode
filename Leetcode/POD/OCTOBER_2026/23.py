class Solution:
    def sortPermutation(self, nums: List[int]) -> int:
        ans=-1
        n=len(nums)
        for e in range(0,n):
            if nums[e] != e:
                ans=ans & nums[e]
        return max(ans,0)    class Solution {
    private static long sumOfIsland(int[][]grid,int r,int c,int row, int cols){
        if(r<0 || c<0 || r>=row || c>=cols){
            return 0;
        }
        if(grid[r][c]==0)return 0;
        int value=grid[r][c];
        grid[r][c]=0;
        long up=sumOfIsland(grid,r-1,c,row,cols);
        long left=sumOfIsland(grid,r,c-1,row,cols);
        long down=sumOfIsland(grid,r+1,c,row,cols);
        long right=sumOfIsland(grid,r,c+1,row,cols);
        return up+left+down+right+value;
    }
    public int countIslands(int[][] grid, int k) {
        int row=grid.length;
        int cols=grid[0].length;
        int count=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]!=0){
                    long sum=sumOfIsland(grid,i,j,row,cols);
                 
                    if(sum%k==0)count++;
                }
            }
        }
        return count;
    }
}