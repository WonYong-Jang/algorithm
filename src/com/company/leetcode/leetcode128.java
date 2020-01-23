package com.company.leetcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class leetcode128 {
    
    public static int N;
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        
    }
   
}


/**
class Solution {
    public int longestConsecutive(int[] nums) {
        
        int len = nums.length;
        if(len == 0) return 0;
        int result = 1;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i< len; i++)
        {
            set.add(nums[i]);
        }
        
        for(int cur : set)
        {
            if(!set.contains(cur-1))
            {
                int maxLen = 1;
                int index = cur+1;
                
                while(set.contains(index))
                {
                    maxLen++;
                    index++;
                }
                result = max(result, maxLen);
            }
        }
        
        return result;
    }
    public int max(int a, int b) { return a > b ? a: b ;}
}
 */


