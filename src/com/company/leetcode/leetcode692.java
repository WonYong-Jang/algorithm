package com.company.leetcode;

public class leetcode692 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
import java.util.*;
    
class Solution {
    public HashMap<String, Integer> map = new HashMap<>();
    public List<String> answer = new ArrayList<>();
    public List<String> topKFrequent(String[] words, int k) {
        
        int len = words.length;
        
        for(int i=0; i< len; i++)
        {
            map.put(words[i], map.getOrDefault(words[i],0) + 1);
        }
        
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new mySort());
        
        for(int i=0; i< k; i++)
        {
            answer.add(list.get(i));
        }
        
        return answer;
    }
    public class mySort implements Comparator<String> {
        @Override
        public int compare(String a, String b)
        {
            if(map.get(a).compareTo(map.get(b)) > 0) return -1;
            else if(map.get(a).compareTo(map.get(b)) < 0) return 1;
            else {
                if(a.compareTo(b) < 0) return -1;
                else if(a.compareTo(b) > 0) return 1;
                else return 0;
            }
        }
    }
} 
 */
