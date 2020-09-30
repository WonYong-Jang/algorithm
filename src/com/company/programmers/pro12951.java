package com.company.programmers;

public class pro12951 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
}

/**
import java.util.*;

class Solution {
    public String solution(String s) {
        
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        
        String[] str = s.toLowerCase().split("");
        
        boolean flag = false;
        for(int i=0; i< len; i++) {
            if(str[i].equals(" ")) flag = false;
            else if(!flag) {
                flag = true;
                str[i] = str[i].toUpperCase();
            }
            sb.append(str[i]);
        }
        
        return sb.toString();
    }
}
 */
