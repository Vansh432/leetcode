import java.util.*;
class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
    if (a[1] != b[1]) return Integer.compare(a[1], b[1]); // main priority: cell [1]
    return Integer.compare(a[0], b[0]);                   // tie: lower cell [0] first
});
   TreeSet<Integer> tree=new TreeSet();
   for(int i=0;i<k;i++){
    tree.add(i);
   }
    int n=arrival.length;
    
       int[] numberOfRequest=new int[k];
       for(int i=0;i<n;i++){
         int atArrival=arrival[i];

         while(!pq.isEmpty() && pq.peek()[1]<=atArrival)tree.add(pq.poll()[0]);
         if(tree.isEmpty())continue;        
        
         Integer lowest=tree.ceiling(i%k);
         if(lowest==null)lowest=tree.first();
         int[] a=new int[2];
         a[0]=lowest;
         a[1]=atArrival+load[i];
         pq.offer(a);
         tree.remove(lowest);
         numberOfRequest[lowest]++;
       }
       int maxRequest=0;
       List<Integer> arr=new ArrayList();
       for(int i=0;i<k;i++){
          maxRequest=Math.max(maxRequest,numberOfRequest[i]);
       }

       for(int i=0;i<k;i++){
        if(maxRequest==numberOfRequest[i]){
            arr.add(i);
        }

       }

       return arr;
    }
}