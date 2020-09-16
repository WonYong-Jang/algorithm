package com.company.leetcode;

public class leetcode795 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }   
}
/**
class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        
        int left = 0, right = 0;
        int answer = 0;
        int len = A.length;
        
        if(len ==0) return 0;
        
        int num = 0;
        for(int i=0; i< len; i++) {
            
            int target = A[i];
            
            if(target >= L && target <= R) {
                right = i+1;
                answer += (right-left);
            }
            else if(target > R) {
                left = i+1;
                right = i+1;
            }
            else if(right - left > 0) {
                answer += (right-left);
            }
        }
        
        
        return answer;
    }
} 
 */
