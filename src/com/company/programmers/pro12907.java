package com.company.programmers;

public class pro12907 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }    
}
/**
class Solution {
    public int solution(int n, int[] money) {
        
        int mod = 1000000007;
        
        int row = money.length;
        
        if(n ==0 || row == 0) return 0;
        
        int[][] dp = new int[row+1][n+1];
        
        for(int i = 1; i <= row; i++) dp[i][0] = 1;
        
        for(int i=1; i<= row; i++) {
            for(int j=1; j<= n; j++) {
                
                int num = 0;
                if(j - money[i-1] >= 0) num = dp[i][j-money[i-1]];
                
                dp[i][j] = (num + dp[i-1][j]) % mod;
            }
        }
         
        return dp[row][n];
    }
}

 */
