package com.company.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class leetcode392 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        HashMap<Character, Queue<Integer>> map = new HashMap<>();
        
        char ch = 'a';
        Queue<Integer> que = map.getOrDefault(ch, new LinkedList<>());
        que.add(1);
        
    }
}

/**
class Solution {
    public boolean isSubsequence(String s, String t) {
        
        
        int tLen = t.length();
        int sLen = s.length();
        
        HashMap<Character, Queue<Integer>> map = new HashMap<>();
        for(int i=0; i< tLen; i++)
        {
            char ch = t.charAt(i);
            Queue<Integer> que = map.getOrDefault(ch, new LinkedList<>());
            que.add(i);
            map.put(ch, que);
        }
        int index = -1;
        for(int i=0; i< sLen; i++)
        {
            char ch = s.charAt(i);
            Queue<Integer> que = map.getOrDefault(ch, new LinkedList<>());
            if(que.size() == 0) return false;
            
            int temp = 0;
            while(!que.isEmpty())
            {
                temp = que.poll();
                if(temp > index) break;
            }
            if(temp < index) return false;       
            index = temp;
            map.put(ch, que);
            
        }
        
        
        return true;
    }
}
 */
