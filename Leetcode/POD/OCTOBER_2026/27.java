class Solution {
    public String[] createGrid(int m, int n) {
        String[] ans=new String[m];
         if(m==1){
             StringBuilder str=new StringBuilder();
            for(int i=0;i<n;i++){
                str.append(".");
            }
            ans[0]=str.toString();
            return ans;
         }
         for(int i=0;i<m;i++){
            StringBuilder str=new StringBuilder();
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    str.append(".");
                }else if(i==m-1 && j==n-1){
                    str.append(".");
                }else if(j==n-1 || i==0){
                    str.append(".");
                }else{
                    str.append("#");
                }
            }
            ans[i]=str.toString();
         }
         return ans;
    }
}