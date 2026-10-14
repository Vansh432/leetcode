class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder result=new StringBuilder();
        long totalSquare=0;
        int ninethCount=sum/9;
        int reminder=sum%9;
        int total=1;
        while(num>0 && ninethCount>0){
                result.append("9");
                ninethCount--;
                num--;
        }
        while(num-->0){
            if(reminder>0){
                result.append(reminder);
                reminder=0;
            }else{
                result.append("0");
            }
        }
        if(num|| sum!=total) return "";
        return result.toString();
    }
}