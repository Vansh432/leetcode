class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
     long v1=((long)cost1 * (long)need1) + (long)costBoth * (long)need2;
     long v2=(long)costBoth * need1 + (long)cost2 * need2;
     long v3= (long)cost1 * (long)need1 + (long)cost2 * (long)need2;
     int max=need1>need2?need1:need2;
     long v4= (long)costBoth * (long)max;
     long min=Math.min(v1,v2);
     long min2=Math.min(v3,v4);
     long v5=0;

     if(need1>need2){
        v5=(long)costBoth * (long)need2;
        v5+=(long)cost1*((long)need1 - (long)need2);
     }else{
        v5=(long)costBoth * (long)need1;
        v5+=(long)cost2 * ((long)need2 - (long)need1 );
     }
     long min3=Math.min(min,v5);
     System.out.println(v1+" "+v2+" "+v4+" "+v5);
     return Math.min(min3,min2);
    }
}