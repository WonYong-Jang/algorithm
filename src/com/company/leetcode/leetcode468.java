package com.company.leetcode;

public class leetcode468 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
        
        String[] arr = str.split(":");
        
        int len = arr.length;
        for(int i=0; i< len; i++)
        {
            System.out.println(arr[i]);
        }
        
    }
}
/**
class Solution {
    public String validIPAddress(String IP) {
        
        int len = IP.length();
        if(len == 0) return "Neither";
        
        String[] str1 = IP.split("\\.");
        String[] str2 = IP.split(":");
        
        int len1 = str1.length;
        int len2 = str2.length;
        
        if(len1 == 4 && len2 == 1)
        {
            if(IP.charAt(0) == '.' || IP.charAt(len-1) == '.') return "Neither";
            for(int i=0; i< len1; i++)
            {
                
                if(str1[i].length() > 1 && str1[i].charAt(0) == '0') return "Neither"; 
                
                int L = str1[i].length();
                if(L > 3 || L <= 0) return "Neither";
                for(int j=0; j< L; j++)
                {
                    if(str1[i].charAt(j) < '0' || str1[i].charAt(j) > '9') return "Neither"; 
                }
                if(str1[i].equals("")) return "Neither";
                int num = Integer.parseInt(str1[i]);    
                
                
                if(num < 0 || num > 255) return "Neither";
            }
            
            return "IPv4";
        }
        else if(len1 == 1 && len2 == 8)
        {
            if(IP.charAt(0) == ':' || IP.charAt(len-1) == ':') return "Neither";
            int cnt = 0;
            
            for(int i=0; i< len2; i++)
            {
                int L = str2[i].length();
                if(L > 4 || L <= 0)  return "Neither";
                for(int j=0; j< L; j++)
                {
                    char ch = str2[i].charAt(j);
                    if(!((ch >= '0' && ch <= '9') || (ch>='a' && ch<='f') || (ch>='A' &&ch<='F'))) return "Neither";
                }
            }
            
            return "IPv6";
        }
        
        
        return "Neither";
    }
}
 */

