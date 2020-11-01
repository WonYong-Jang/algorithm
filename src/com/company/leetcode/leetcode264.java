package com.company.leetcode;

import java.util.HashSet;

public class leetcode264 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        HashSet<Long> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        
    }   
}
/**
class Solution {
    public int nthUglyNumber(int n) {
        
        if(n == 0) return 0;
        return solve(n);
    }
    public int solve(int n) {
        
        int[] prime = new int[]{2,3,5};
        HashSet<Long> set = new HashSet<>();
        PriorityQueue<Long> que = new PriorityQueue<>();
        
        que.add(1L);
        set.add(1L);
        int cnt = 0;
        int answer = 0;
        while(!que.isEmpty()) {
            
            cnt++;
            long num = que.poll();
            
            if(cnt == n) {
                answer = (int)num;
                break;
            }
            
            long next = 0;
            for(int i=0; i<3; i++) {
                
                next = num*(long)prime[i];
                if(set.contains(next)) continue;
                set.add(next);
                que.add(next);
            }   
        }
        
        return answer;
    }
}
 */

