package com.company.leetcode;

public class leetcode13 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    public int romanToInt(String s) {
        
        int len = s.length();
        int sum = 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        for(int i=len-1; i >= 0; i--)
        {
            int right = map.get(s.charAt(i));
            if(i-1 < 0 || map.get(s.charAt(i-1)) >= right  ) sum += right; 
            else {
                sum += (right - map.get(s.charAt(i-1)));
                i--;
            }
        }
        
        if(len == 1) return map.get(s.charAt(0));
        else return sum;
    }
}
 */
