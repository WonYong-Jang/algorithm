package com.company.leetcode;

public class leetcode43 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
}
/**
import java.util.*;

class Solution {
    public String multiply(String num1, String num2) {
        
        if(num1.equals("0") || num2.equals("0")) return "0";
        
        List<String> list = new ArrayList<>();
        
        int len1 = num1.length();
        int len2 = num2.length();
        
        int next = 0, sum = 0;
        
        StringBuilder sb;
        StringBuilder digit = new StringBuilder();
        for(int i = len1-1; i >= 0; i--) {
            
            sum = 0; next = 0;
            
            sb = new StringBuilder();
            for(int j= len2-1; j>=0; j--) {
                int val1 = num1.charAt(i) - '0';
                int val2 = num2.charAt(j) - '0';
                
                int mul = val1 * val2 + next;
                
                sb.append(mul%10);
                next = mul / 10;
            }
            if(next != 0) sb.append(next);
            sb.reverse();
            
            if(digit.length() > 0 ) sb.append(digit.toString()); 
            digit.append("0");
            list.add(sb.toString());
        }
        
        String answer= "0";
        
        for(int i = 0; i< list.size(); i++) {
            answer = sumString(answer, list.get(i));
        }
        
        return answer;
    }
    public String sumString(String num1, String num2) {
        
        
        int idx1 = num1.length() - 1;
        int idx2 = num2.length() - 1;
        
        int val1 = 0, val2 = 0, sum =0, next =0;
        StringBuilder sb = new StringBuilder();
        
        while(idx1 > -1 || idx2 > -1) {
        
            
            if(idx1 == -1) val1 = 0;
            else {
                val1 = num1.charAt(idx1) - '0';
                idx1--;
            }
            
            if(idx2 == -1) val2 = 0;
            else {
                val2 = num2.charAt(idx2) - '0';
                idx2--;
            }
            
            sum = val1 + val2 + next;
            
            sb.append(sum % 10);
            next = (sum/10);
            
        }
        if(next > 0) sb.append(next);
        
        return sb.reverse().toString();
    }
}


 **/
