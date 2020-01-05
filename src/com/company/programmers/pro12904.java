package com.company.programmers;
/**
 * 가장 긴 팰린드롬 
 */
public class pro12904 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
}
/*
 * import java.util.*;

class Solution
{
    public int solution(String s)
    {
        
        int maxLen = 1, answer = 1; 
        int len = s.length();
        if(len == 0) return 0;
        
        int start = 0, end = 0;
        for(int i=0; i< len; i++)
        {
            
            // 홀수 팰린드롬 
            start = i-1; end = i+1;
            maxLen = 1;
            while(start >= 0 && end <= len-1)
            {
                if(s.charAt(start) == s.charAt(end))
                {
                    maxLen += 2;
                    answer = max(answer, maxLen);
                    start--;
                    end++;
                }
                else break;
            }
            
            //짝수 팰린드롬
            start = i-1; end = i;
            maxLen = 0;
            while(start >= 0 && end <= len-1)
            {
                if(s.charAt(start) == s.charAt(end))
                {
                    maxLen += 2;
                    answer = max(answer, maxLen);
                    start--;
                    end++;
                }
                else break;
            }
        }
        
        
        return answer;
    }
    public int max(int a, int b) { return a > b ? a : b ;}
}
 */
