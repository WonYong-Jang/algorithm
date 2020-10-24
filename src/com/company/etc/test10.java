package com.company.etc;

import java.util.HashMap;
import java.util.Map;

public class test10 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    public int solution(String S) {
        // write your code in Java SE 8
        
        int answer = 0;
        int len = S.length();
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i< len; i++) {
            char ch = S.charAt(i);
            
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }
        
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            int chCount = entry.getValue();
            if(chCount % 2 != 0) answer++;
        }
        
        return answer;
    }
}
