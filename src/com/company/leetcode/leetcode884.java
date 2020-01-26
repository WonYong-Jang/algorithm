package com.company.leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

public class leetcode884 {
    
    public static HashMap<String, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        StringTokenizer st = new StringTokenizer("this apple is sweet apple");
        
        while(st.hasMoreTokens())
        {
            String cur = st.nextToken();
            map.merge(cur, 0, (k, v)->++v);
        }
        
        Set<Entry<String, Integer>> set = map.entrySet();
        
        for(Entry<String, Integer> cur : set)
        {
            System.out.println(cur.getKey());
            System.out.println(cur.getValue());
        }
        
        map.forEach((k,v) -> {
            System.out.println(k);
            System.out.println(v);
        });
        ArrayList<String> arr = new ArrayList<>();
        String[] test = (String[]) arr.toArray();
    }
    
}



/**
import java.util.*;

class Solution {
    
    public HashMap<String, Integer> map = new HashMap<>();
    public String[] uncommonFromSentences(String A, String B) {
        
        StringTokenizer st = new StringTokenizer(A);
        
        String cur = "";
        while(st.hasMoreTokens())
        {
            cur = st.nextToken();
            map.merge(cur, 0, (k,v)-> ++v);
        }
        
        st = new StringTokenizer(B);
        
        while(st.hasMoreTokens())
        {
            cur = st.nextToken();
            map.merge(cur, 0, (k,v)-> ++v);
        }
        
        ArrayList<String> arr = new ArrayList<>();
        
        map.forEach((k, v) -> {
           if(v == 0) {
               arr.add(k);
           }
        });
        
        return arr.toArray(new String[arr.size()]);
    }
}
**/
