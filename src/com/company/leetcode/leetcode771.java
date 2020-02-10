package com.company.leetcode;

public class leetcode771 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        int num = 101;
        String target = Integer.toString(num);
        System.out.println(target);
        
        
    }
    
}

/**
class Solution {
    public int numJewelsInStones(String J, String S) {
        
        int len = S.length();
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i< len; i++)
        {
            char ch = S.charAt(i);
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }
        
        int ans = 0;
        len = J.length();
        
        for(int i=0; i < len; i++)
        {
            char ch = J.charAt(i);
            ans += map.getOrDefault(ch,0);
        }
        
        return ans;
    }
}
 */

