package com.company.leetcode;

public class leetcode477 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }    
}
/**

    
class Solution {
    public int totalHammingDistance(int[] nums) {
        
        int len = nums.length;
        int answer = 0;
        
        
        for(int i=0; i< 32; i++) {
            
            int onCount =0;    
            for(int target : nums) {
                
                if( (target & ( 1 << i)) > 0 ) {
                    onCount++;
                }
            }
            
            answer += (onCount*(len-onCount));
        }     
        
        return answer;
    }
}

 */
