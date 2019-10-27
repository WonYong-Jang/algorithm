package com.company.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * Top k frequent elements ( hashmap value 정렬 )
 *
 */
public class leetcode347 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }    
}

class Solution347 {
    
    public HashMap<Integer, Integer> map = new HashMap<>();
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        List<Integer> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        
        for(int i=0; i< len; i++)
        {
            int idx = nums[i];
            if(map.containsKey(idx)) {
                int num = map.get(idx);
                map.put(idx, num+1);
            }
            else {
                map.put(idx, 1);
            }
        }
        
        list.addAll(map.keySet());
        
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                // TODO Auto-generated method stub
                int num1 = map.get(a);
                int num2 = map.get(b);
                if(num1 < num2) return 1;
                else if(num1 > num2) return -1;
                else return 0;
            }
        });
        
        ans.add(list.get(0));
        int num = map.get(list.get(0));
        int maxNum = num;
        k--;
        for(int i=1; i< list.size(); i++)
        {
            num = map.get(list.get(i));
            if(maxNum == num) {
                k--;
            }
            else {
                if(k <= 0) break;
                k--;
                maxNum = num;
            }
            ans.add(list.get(i));
        }
        
        return ans;
    }
}