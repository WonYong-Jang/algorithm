package com.company.leetcode;

import java.util.HashMap;

public class leetcode953 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        HashMap<Character, Integer> map = new HashMap<>();
        
    }
    
}
/**
class Solution {
    public HashMap<Character, Integer> map;
    public boolean isAlienSorted(String[] words, String order) {
        
        map = new HashMap<>();
        int len = order.length();
        for(int i=0; i< len; i++)
        {
            map.put(order.charAt(i),i);
        }
        
        for(int i=0; i< words.length-1; i++)
        {
            if(!isCheck(words[i], words[i+1])){
                return false;
            }
        }
        
        
        return true;
    }
    public boolean isCheck(String str1, String str2)
    {
        int len1 = str1.length();
        int len2 = str2.length();
        int index =0;
        
        while(index >=0 && index < len1 && index < len2)
        {
            char ch1 = str1.charAt(index);
            char ch2 = str2.charAt(index);
            
            int result1 = map.get(ch1);
            int result2 = map.get(ch2);
            
            if(result1 > result2) return false;
            else if(result1 < result2) return true;
            
            index++;
        }
        
        if(len1 > len2) return false;
        else return true;
    }
}
**/
