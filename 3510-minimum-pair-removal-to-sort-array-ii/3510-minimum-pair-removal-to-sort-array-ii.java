class Solution {
    static class Node implements Comparable<Node>{
        long sum;
        int idx;
        Node(long sum,int idx){
           this.sum=sum;
            this.idx=idx;
        }
    
    @Override 
 public int compareTo(Node other){
     if(this.sum!=other.sum){
         return Long.compare(this.sum,other.sum);
     }
     return Integer.compare(this.idx,other.idx);
 }
    }
    public int minimumPairRemoval(int[] nums) {
  int n=nums.length;
        if(n<=1)return 0;
    long[]temp=new long[n];
 int[]pre=new int[n],next=new int[n];
 boolean[]remove=new boolean[n];
    for(int i=0;i<n;i++){
        temp[i]=nums[i];
        pre[i]=i-1;
        next[i]=(i+1<n)?i+1:-1;
    }
    PriorityQueue<Node>pq=new PriorityQueue<>();
    for(int i=0;i<n-1;i++){
    pq.offer(new Node(temp[i]+temp[i+1],i));
        }
        int bad=0;
 for(int i=0;i<n-1;i++)
     if(temp[i]>temp[i+1]) bad++;
    int ops=0;
    while(bad>0&&!pq.isEmpty()){
        Node top=pq.poll();
    int i=top.idx;
    long sum=top.sum;
 if(remove[i]||next[i]==-1) continue;
    int j=next[i];
    if(remove[i]||temp[i]+temp[j]!=sum) continue;
 int left=pre[i],right=next[j];
 if(left!=-1&&temp[left]>temp[i])bad--;
        if(temp[i]>temp[j]) bad--;
    if(right!=-1&&temp[j]>temp[right])bad--;
        temp[i]=sum;
        remove[j]=true;
        next[i]=right;
    if(right!=-1) pre[right]=i; if(left!=-1&&temp[left]>temp[i])bad++;
    if(right!=-1&&temp[i]>temp[right])bad++;
 if(left!=-1) pq.offer(new Node(temp[left]+temp[i],left));
 if(right!=-1) pq.offer(new Node(temp[i]+temp[right],i));
        ops++;
     }
        return ops;
     }
}