package com.company.programmers;

public class pro12983 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    public int INF = 20005;
    public int solution(String[] strs, String t) {
        int answer = 0;
        int N = t.length(), M = strs.length, len = 0;
        int[] dp = new int[N+1];
        
        for(int i = 1; i <= N; i++)
        {
            dp[i] = INF;
            for(int j = 0; j < M; j++)
            {
                len = strs[j].length();
                int start = i - len;
                if(start < 0) continue;
                if(strs[j].charAt(len-1) == t.charAt(i-1))
                {
                    int index = 0;
                    boolean flag = true;
                    for(int k = start; k < i-1; k++)
                    {
                        if(t.charAt(k) != strs[j].charAt(index++)){
                            flag = false;
                            break;
                        }
                    }
                    if(flag) dp[i] = Math.min(dp[i], dp[start]+1);
                }
            }
        }
        
        for(int i=0; i<= N; i++)
        {
            System.out.println(dp[i]);
        }
        if(dp[N] >= INF) answer = -1;
        else answer = dp[N];
        return answer;
    }
}
*/
