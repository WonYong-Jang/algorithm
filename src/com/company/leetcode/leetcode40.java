package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode40 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        
    }
}
/**
class Solution {
    
    public HashMap<Integer, String> map;
    public int[] visit;
    public List<String> answer;
    public int len;
    public StringBuilder sb;
    public List<String> letterCombinations(String digits) {
        
        
        len = digits.length();
        answer = new ArrayList<>();
        if(len == 0) return answer;
        
        visit = new int[len];
        map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        
        sb = new StringBuilder();
        
        for(int i=0; i< len; i++) {
            
            int num = digits.charAt(i) - '0';
            String target = map.get(num);
            visit[i] = 1;
            
            for(int j=0; j< target.length(); j++) {
                        
                char ch = target.charAt(j);
                sb.append(ch);
                search(1, i, digits);
                sb.deleteCharAt(sb.length()-1);
            }
            
            visit[i] = 0;
        }
        
        
        return answer;
    }
    public void search(int size ,int cur, String digits) {
        
        if(size == len) {
            
            //System.out.println(sb.toString());
            answer.add(sb.toString());
            
            return;
        }
        
        for(int i= cur + 1; i< len; i++) {
            
            if(visit[i] == 1) continue;
            
            int num = digits.charAt(i) - '0';
            String target = map.get(num);
            visit[i] = 1;
            
            for(int j=0; j< target.length(); j++) {
                char ch = target.charAt(j);
                sb.append(ch);
                search(size+1, i, digits);
                sb.deleteCharAt(sb.length()-1);
                
            }
            
            visit[i] = 0;
            
        }
        
    }
} 
 */
