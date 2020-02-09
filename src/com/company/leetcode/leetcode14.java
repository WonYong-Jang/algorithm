package com.company.leetcode;

public class leetcode14 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if(strs.length == 0) return "";
        
        StringBuilder sb = new StringBuilder();
        
        int index = 0;
        while(true)
        {
            boolean flag = true;
            char target = 0;
            for(int i=0; i< strs.length; i++)
            {
                int len = strs[i].length();
                if(len <= index) {
                    flag = false;
                    break;
                }
                
                if(target == 0) target = strs[i].charAt(index);
                else if(target != strs[i].charAt(index)) {
                    flag = false;
                    break;
                }
            }   
            if(!flag) break;
            sb.append(target);
            index++;
        }
        
        return sb.toString();
    }
} 
 */
