package com.company.leetcode;
/**
 * 461 Hamming Distance
 */
public class leetcode461 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    public int hammingDistance(int x, int y) {
        
        int num = x ^ y;
        
        int ans = 0;
        while(num > 0)
        {
            ans += (num & 1);
            num >>= 1;
            
        }
        
        return ans;
    }
} 
 */
