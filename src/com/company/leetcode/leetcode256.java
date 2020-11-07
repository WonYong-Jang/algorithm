package com.company.leetcode;

public class leetcode256 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
}
/**
class Solution {
    public int minCost(int[][] costs) {
        
        return solve(costs);   
    }
    public int solve(int[][] costs) {
        
        int answer = 100 * 30;
        int row = costs.length;
        if(row == 0) return 0;
        
        int col = costs[0].length;
        int[][] dp = new int[row][col];
        
        for(int i=0; i< row; i++) {
            for(int j=0; j< col; j++) {
                
                if(i == 0) dp[0][j] = costs[0][j];
                else {
                    
                    dp[i][j] = costs[i][j];
                    if(j == 0) {
                        dp[i][j] += Math.min(dp[i-1][j+1], dp[i-1][j+2]);
                    }
                    else if(j == 1) {
                        dp[i][j] += Math.min(dp[i-1][j-1], dp[i-1][j+1]);
                    }
                    else {
                        dp[i][j] += Math.min(dp[i-1][j-2], dp[i-1][j-1]);
                    }
                }
                
                if(i == row-1) answer = Math.min(answer, dp[i][j]);
            }
        }
        return answer;
    }
} 
 */
