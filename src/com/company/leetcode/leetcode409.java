package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class leetcode409 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
}
/**
class Solution {
    public int longestPalindrome(String s) {
        
        int len = s.length();
        int answer = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i< len; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        
        int odd = 0, center = 0;
        for(Map.Entry<Character,Integer> set : map.entrySet()) {
            
            int num = set.getValue();
            if(num % 2 ==0) answer += num;
            else {
                if(center == 1 && num == 1) continue;
                if(center == 0) {
                    center = 1;
                    answer++;
                }
                if(num > 1) {
                    answer += (num-1);
                }
                
            }
        }
        
        
        return answer;
    }
} 
 */
