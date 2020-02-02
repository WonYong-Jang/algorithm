package com.company.leetcode;

public class leetcode7 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str = "123";
        StringBuilder sb = new StringBuilder();
 
    }   
}

/**
class Solution {
    public int reverse(int x) {
        
        if(x == 0) return 0;
        
        String str = Integer.toString(x);
        int len = str.length();
        StringBuilder sb = new StringBuilder(str);
        StringBuilder ans = new StringBuilder();
        sb.reverse();
        
        int sign = 1, mul = 1, num = 0;
        boolean flag = false;
        for(int i= 0; i < len ; i++)
        {
            char ch = sb.charAt(i);
            if(ch == '-') {
                sign = -1;
            }
            else {
                num = ch - '0';
                if(!flag && num > 0) {
                    flag = true;
                }
                if(!flag) continue;
                ans.append(ch);
                
            }
            
        }
        
        long temp = Long.parseLong(ans.toString());
        if(Integer.MIN_VALUE <= temp && temp <= Integer.MAX_VALUE)
        {
            num = Integer.parseInt(ans.toString());
            num *= sign;
            return num;
        }
        else return 0;
    }
} 
 */
