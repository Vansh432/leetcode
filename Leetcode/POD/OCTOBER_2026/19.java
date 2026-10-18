class Solution {
    static long[][] comb;
    private static final int MOD=1_000_000_007;
    public int numOfWays(int[] nums) {
        int n=nums.length;
        comb=new long[n][n];
        for(int i=0;i<n;i++){
            comb[i][0]=1;
            for(int j=1;j<=i;j++){
               long x=comb[i-1][j-1];
               long y=comb[i-1][j];
               comb[i][j]=(x+y)%MOD;
            }
        }
        List<Integer> list=new ArrayList();
        for(int e:nums)list.add(e);
        long totalIndenticalBST=indenticalBSTCount(list);

        return (int)(totalIndenticalBST-1 + MOD) % MOD;
    }
    private static long indenticalBSTCount(List<Integer> list){
        int size=list.size();
        if(size<=2) return 1;
        int root=list.get(0);
        List<Integer> left=new ArrayList();
        List<Integer> right=new ArrayList();

        for(int i=1;i<size;i++){
            if(list.get(i)<root){
            left.add(list.get(i));
            }else{
                right.add(list.get(i));
            }
        }
        long combination=comb[size-1][left.size()];
        long leftSubtree=(combination *indenticalBSTCount(left))% MOD;
        long rightSubtree=(leftSubtree * indenticalBSTCount(right)% MOD);
    
        return rightSubtree % MOD;
    }
}
