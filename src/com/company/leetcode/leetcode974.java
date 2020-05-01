package com.company.leetcode;

public class leetcode974 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    public int subarraysDivByK(int[] A, int K) {
      
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum =0, ans = 0;
        for(int num : A) {
            sum += num;
            int mod = sum % K;
            if(mod < 0) mod += K;
            ans += map.getOrDefault(mod, 0);
            
            map.put(mod, map.getOrDefault(mod,0) + 1);
        }
        
        
        return ans;
    }
    
} 
 */
