package com.company.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class leetcode239 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Deque<Integer> que = new ArrayDeque<>();
        
    }
    
}
/**
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int len = nums.length;
        int[] ans = new int[len-k+1];
        Deque<Node> que = new ArrayDeque<>();
        int index = -1;
        for(int i=0; i< len; i++) {
            
            Node cur = null;
            while(!que.isEmpty()) {
                cur = que.peekLast();
                if(cur.num <= nums[i]) que.pollLast();
                else break;
            }
            que.addLast(new Node(nums[i], i));
            
            while(!que.isEmpty()) {
                cur = que.peekFirst();
                int time = i - k + 1;
                if(time <= cur.index && cur.index <= i) break;
                else que.pollFirst();
            }
            
            if(k-1 <= i) {
                ans[++index] = que.peekFirst().num;    
            }
        }
        return ans;
    }
    public class Node {
        int num, index;
        Node(int a, int b) {
            num = a; index = b;
        }
    }
} 
 */
