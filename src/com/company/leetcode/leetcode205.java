package com.company.leetcode;

import java.util.HashMap;
import java.util.HashSet;

// isomorphics Strings

public class leetcode205 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        
    }
    
}
/*
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int len = s.length();
        
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        
        char source = 0, target = 0;
        for(int i=0; i< len; i++)
        {
            source = s.charAt(i);
            target = t.charAt(i);
            set1.add(source);
            set2.add(target);
            if(map.containsKey(source))
            {
                char str = map.get(source);
                if(target != str) return false;
            }
            else map.put(source, target);
        }
        
        if(set1.size() == set2.size()) return true;
        else return false;
    }
}
*/