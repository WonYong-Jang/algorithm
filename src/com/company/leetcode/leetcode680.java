package com.company.leetcode;
/**
 * 680. Valid Palindrome II
 */
public class leetcode680 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
 class Solution {
    public String str;
    public boolean validPalindrome(String s) {
        
        int len = s.length();
        str = s;
        
        int start = 0, end = len-1;
        boolean answer = true;
        while(start < end)
        {
            if(s.charAt(start) == s.charAt(end))
            {
                start++;
                end--;
            }
            else {
                if(solve(start,end-1) == false && solve(start+1,end) == false) {
                    answer = false;
                }
                break;
            }
        }
        
        return answer;
    }
    public boolean solve(int start, int end)
    {
        boolean flag = true;
        
        while(start < end)
        {
            if(str.charAt(start) == str.charAt(end))
            {
                start++;
                end--;
            }
            else {
                flag = false;      
                break;
            }
            
        }
        
        return flag;
    }
}
 */
