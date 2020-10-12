package com.company.leetcode;

public class leetcode1013 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        
        
        int sum =0;
        
        int len = A.length;
        
        for(int i=0; i< len; i++) sum += A[i];
        
        if(sum % 3 != 0) return false;
        
        int parSum = sum / 3; 
        int curSum = 0;
        int count = 0;
        for(int i=0; i< len; i++) {
            
            curSum += A[i];
            
            if(curSum == parSum) {
                curSum = 0;
                count++;
            }
        }
        
        System.out.println(count);
        
        if(count >= 3) return true;
        else return false;
    }
} 
 */
