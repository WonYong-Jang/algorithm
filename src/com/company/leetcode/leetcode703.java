package com.company.leetcode;
/**
 * mean Heap
 */
public class leetcode703 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class KthLargest {

    public PriorityQueue<Integer> que = new PriorityQueue<>();
    public int len, K;
    public KthLargest(int k, int[] nums) {
        
        len = nums.length;
        K = k;
        for(int i=0; i< len; i++)
        {
            que.add(nums[i]);
        }
        
        while(!que.isEmpty())
        {
            if(que.size() > k) que.poll();
            else break;
        }
        
    }
    public int add(int val) {
        
        que.add(val);
        
        if(que.size() > K) que.poll();
        
        return que.peek();
    }
   
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
