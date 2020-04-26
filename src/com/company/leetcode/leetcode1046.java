package com.company.leetcode;

public class leetcode1046 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    public int lastStoneWeight(int[] stones) {
        
        return solve(stones);
    }
    public int solve(int[] stones) {
        
        int ans = 0;
        int len = stones.length;
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i< len; i++) que.offer(stones[i]);
        
        while(!que.isEmpty()) {
            if(que.size() <= 1) {
                break;
            }
            
            int num1 = que.poll();
            int num2 = que.poll();
            
            if(num1 == num2) continue;
            else {
                int result = num1 > num2 ? num1 - num2 : num2 - num1;
                que.offer(result);
            }
            
        }
        
        if(!que.isEmpty()) ans = que.peek();
        
        return ans;
    }
} 
 */
