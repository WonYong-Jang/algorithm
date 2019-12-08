package com.company.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Approach 1: Categorize by Sorted String
 */
public class leetcode49 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<List<String>> list = new ArrayList<>(); 
        
        HashMap<String, List<String>> map = new HashMap<>();
        
        String[] strs = {"abcde", "abcde"};
        
        
        
        
        
    }
    
}



/**
class Solution {
    
    public HashMap<String, List<String>> map = new HashMap<>();
    public int[] count = new int[26];
    public List<List<String>> groupAnagrams(String[] strs) {
        
        for(String cur : strs)
        {
            char[] ch = cur.toCharArray();
            
            Arrays.fill(count, 0);
            
            for(char node : ch)
            {
                count[node-'a']++;
            }
            
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< 26; i++)
            {
                sb.append(count[i]);
            }
            
            if(!map.containsKey(sb.toString())) {   
                map.put(sb.toString(), new ArrayList<>());
            }    
            map.get(sb.toString()).add(cur);
            
        }
        
        return new ArrayList(map.values());
    }
}
 */
