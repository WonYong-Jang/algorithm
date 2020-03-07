package com.company.programmers;

public class pro43105 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    public int solution(int[][] triangle) {
        
        int row = triangle.length;
        int[][] dp = new int[row][row];
        
        int ans = 0;
        for(int i=0; i< row; i++) {
            for(int j=0; j< triangle[i].length; j++) {
                int left=0,right=0;
                
                if(i-1 >= 0 && j-1 >=0) left = dp[i-1][j-1];
                if(i-1 >= 0) right = dp[i-1][j];
                
                dp[i][j] = Math.max(left, right) + triangle[i][j];
                ans = Math.max(ans, dp[i][j]);
            }
        }
        
        
        return ans;
    }
} 
 */
