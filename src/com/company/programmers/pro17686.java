package com.company.programmers;

import java.util.Arrays;
import java.util.Comparator;

public class pro17686 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
       
        
    }
}

/**
import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        
        int len = files.length;
        if(len == 0) return null;
        
        Arrays.sort(files, new mySort());
        return files;
    }
    public class mySort implements Comparator<String> {
        public int compare(String a, String b) {
            
            String[] str1 = detach(a);
            String[] str2 = detach(b);
            
            if(str1[0].equals(str2[0])) {
                
                Integer num1 = Integer.parseInt(str1[1]);
                Integer num2 = Integer.parseInt(str2[1]);    
                
                return num1 - num2;
            }
            else return str1[0].compareTo(str2[0]);
            
        }
    }
    public String[] detach(String str) {
        
        int len = str.length();
        String[] answer = new String[3];
        
        String head = "";
        String number = "";
        String tail = "";
        
        int i = 0;
        int s = 0;
        for(; i < len; i++) {
            char ch = str.charAt(i);
            if(ch >= '0' && ch <= '9') {
                break;
            }
            head += ch;
        }
        s = i;
        for(; i < len; i++) {
            if(i >= s + 5) break;
        
            char ch = str.charAt(i);
            if(!(ch >= '0' && ch <= '9')) {
                break;
            }
            number += ch;
        }
        
        answer[0] = head.toLowerCase();
        answer[1] = number;
        
        return answer;
    }
}
 */
