package com.company.leetcode;

public class leetcode204 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    public int countPrimes(int n) {
        
        int[] prime = new int[n+1];
        
        int result = 0;
        for(int i=2; i < n ; i++) {
            if(prime[i] == 1) continue;
            
            prime[i] = 1;
            result++;
            
            for(int j= i+i; j < n; j += i) {
                if(prime[j] == 1) continue;
                prime[j] = 1;
            }
        }
        
        return result;
    }
} 
 */
