package com.company.leetcode;

public class leetcode279 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }   
}
/**
class Solution {
    public int numSquares(int n) {
        
        if(n == 0) return 0;
        
        return solve(n);
    }
    public int solve(int n) {
        
        List<Integer> arr = new ArrayList<>();
        
        int index = 1, val = 0;
        while(true) {
           
            val = index*index;
            if(val > n) break;
            arr.add(val);
            
            index++;
        }
        
        int[] dp = new int[n+1];
        
        for(int i=1; i<= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for(int j=0; j< arr.size(); j++) {
                if(i - arr.get(j) >= 0) {
                    
                    dp[i] = Math.min(dp[i], dp[i-arr.get(j)] +1);
                }
            }
        }
        
        return dp[n];
    }
} 
 */
