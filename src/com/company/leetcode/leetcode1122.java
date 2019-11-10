package com.company.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/*
 * Relative Sort array
 */
public class leetcode1122 {
    
    public static HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
}

class Solution1122 {
    public int[] answer, visit;
    public ArrayList<Integer> arr = new ArrayList<>();
    public HashMap<Integer, Integer> map = new HashMap<>();
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        
        visit = new int[1005];
        answer = new int[len1];
        int num =0, target = 0, index = 0;
        for(int i=0; i< len1; i++)
        {
            if(map.containsKey(arr1[i])) {
                num = map.get(arr1[i]);
                map.put(arr1[i], num+1);
            }
            else {
                map.put(arr1[i], 1);
            }
        }
        
        for(int i=0; i< len2; i++)
        {
            target = map.get(arr2[i]);
            visit[arr2[i]] = 1;
            while(target > 0)
            {
                answer[index] = arr2[i];
                index++;
                target--;
            }
        }
        
        for(int i=0; i< len1; i++)
        {
            if(visit[arr1[i]] == 0) arr.add(arr1[i]);
        }
        Collections.sort(arr);
        for(int i=0; i< arr.size(); i++)
        {
            answer[index] = arr.get(i);
            index++;
        }
        
        return answer;
    }
}