package com.company.leetcode;

import java.util.HashMap;

public class leetcode1002 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        HashMap<String, Integer> map = new HashMap<>();
        String str = "abc";
       
        char tmp = 'a';
        System.out.println(tmp-'a');
    }
}

/**
class Solution {
    public List<String> commonChars(String[] A) {
        int N = A.length;
        
        List<String> list = new ArrayList<>();
        if(N == 0 || A == null) return list;
        
        int[][] map = new int[N][27];
        
        for(int i=0; i< N; i++)
        {
            String str = A[i];
            int len = str.length();
            for(int j=0; j< len; j++)
            {
                char ch = str.charAt(j);
                map[i][ch-'a']++;
            }
        }
        
        for(int i=0; i< 27; i++)
        {
            int num = map[0][i];
            char ch = (char)('a'+i);
            String target = Character.toString(ch);
            for(int j=1; j< N; j++)
            {
                num = min(num, map[j][i]);
            }
            
            for(int k=0; k< num; k++)
            {
                list.add(target);
            }
            
        }
        return list;
    }
    public int min(int a, int b) { return a > b ? b : a;}
}
 */
