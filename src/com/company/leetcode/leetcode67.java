package com.company.leetcode;

public class leetcode67 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
}

/**
class Solution {
    public StringBuilder sb;
    public String addBinary(String a, String b) {
        
        if(a.length() > b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }
        sb = new StringBuilder();
        
        int len1 = a.length();
        int len2 = b.length();
        
        char[] arr1 = new char[len2];
        char[] arr2 = new char[len2];
        
        for(int i =0; i< len1; i++) arr1[i] = a.charAt(len1-i-1);
        for(int i =0; i< len2; i++) arr2[i] = b.charAt(len2-i-1);
        
        int add = 0, left =0, right = 0, sum =0;
        for(int i=0; i< len2; i++) {
            
            left = 0;
            if(i < len1) left = arr1[i] - '0';
            right = arr2[i] - '0';
            sum = left + right + add;
            
            if(sum >= 2) {
                add = 1;
                if(sum == 3) sb.append("1");
                else sb.append("0");
            }
            else {
                add = 0;
                sb.append(sum);
            }
        }
        if(add == 1) sb.append("1");
        
        sb.reverse();
        return sb.toString();
        
    }
    
}



 
 */
