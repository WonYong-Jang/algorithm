package com.company.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Smallest String With Swaps
 */
public class leetcode1202 {
    
    public static HashMap<Integer, PriorityQueue<Character>> map = new HashMap<>();
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
}

/**
class Solution {
    
    public int[] par;
    public HashMap<Integer, PriorityQueue<Character>> map = new HashMap<>();
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int sLen = s.length();
        int pLen = pairs.size();
        par = new int[sLen];
        for(int i=0; i< sLen; i++) par[i] = i;
        
        for(int i =0; i< pLen; i++)
        {
            int a = pairs.get(i).get(0);
            int b = pairs.get(i).get(1);
            union(a, b);
        }
        
        for(int i=0; i< sLen; i++)
        {
            int target = find(i);
            par[i] = target;
            if(map.get(target)==null) map.put(target, new PriorityQueue<>());
            map.get(target).add(s.charAt(i));
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< sLen; i++)
        {
            int target = par[i];
            System.out.println(target);
            sb.append(map.get(target).poll());
        }
        
        return sb.toString();
    }
    public void union(int a, int b)
    {
        int ap = find(a);
        int bp = find(b);
        if(ap != bp) par[ap] = bp;
    }
    public int find(int a)
    {
        if(par[a] == a) return a;
        else return par[a] = find(par[a]);
    }
}



 */
