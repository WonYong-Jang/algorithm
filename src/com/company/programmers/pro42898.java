package com.company.programmers;

public class pro42898 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
 * 등굣길 dp
class Solution {
    public int[][] obs;
    public int[][] dp;
    public int mod = 1000000007;
    public int solution(int m, int n, int[][] puddles) {
        obs = new int[n+1][m+1];
        dp = new int[n+1][m+1];
        
        for(int[] cur : puddles)
        {
            obs[cur[1]][cur[0]] = 1;
        }
        
        dp[1][0] = 1;
        for(int i=1; i<= n; i++)
        {
            for(int j=1; j<= m; j++)
            {
                if(obs[i][j] == 1) dp[i][j] = 0;
                else dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % mod;
            }
        }
        
        return dp[n][m];
    }
    
}
 */
