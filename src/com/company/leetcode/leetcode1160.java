package com.company.leetcode;

public class leetcode1160 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    public int countCharacters(String[] words, String chars) {
        
        int len = chars.length();
        int answer = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char ch = 0;
        for(int i=0; i< len; i++)
        {
            ch = chars.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        int N = words.length;
        for(int i=0; i< N; i++)
        {
            int[] cntArr = new int[26];
            int M = words[i].length();
            boolean flag = true;
            for(int j=0; j< M; j++)
            {
                ch = words[i].charAt(j);
                cntArr[ch-'a']++;
                int num = map.getOrDefault(ch,0);
                if(num == 0 || cntArr[ch-'a'] > num) {
                    flag = false; break;
                }
            }
            if(flag) answer += M;
        }
        
        
        return answer;
    }
} 
 */
