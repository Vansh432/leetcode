class Solution:
    def isCommunicate(self,grid:list[list[int]],r:int,c:int,n:int,m:int):
        for i in range(0,m):
            if grid[r][i]==1 and i!=c:
                return True
        for i in range(0,n):
            if grid[i][c]==1 and i!=r:
                return True
        return False                

    def countServers(self, grid: list[list[int]]) -> int:
        n=len(grid)
        m=len(grid[0])
        count=0
        for i in range(0,n):
            for j in range(0,m):
                if grid[i][j] == 1 and self.isCommunicate(grid,i,j,n,m):
                    count+=1

        return count            


        