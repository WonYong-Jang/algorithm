package com.company.programmers;

public class pro43104 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}

/*
class Solution {
    public long solution(int N) {
        
        long[] fibo = new long[85];
        long[] dp = new long[85];
        
        fibo[1] = 1; fibo[2] = 1;
        for(int i=3; i<= N; i++)
        {
            fibo[i] = fibo[i-1] + fibo[i-2];
        }
        
        dp[1] = 4;
        for(int i=2; i<= N; i++)
        {
            dp[i] = dp[i-1] + (fibo[i]*2);
        }
        
        return dp[N];
    }
}
*/