package com.company.leetcode;

public class leetcode845 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    public int longestMountain(int[] A) {
        
        int len = A.length;
        int answer = 0;
    
        int i = 1;
        while(i < len) {
            
            if(A[i-1] < A[i]) {
                
                int num = 1;
                
                while(i < len && A[i-1] < A[i]) {
                    i++;
                    num++;
                }
                
                if(i < len && A[i-1] > A[i]) {
                    
                    while(i < len && A[i-1] > A[i]) {
                        i++;
                        num++;
                    }
                    
                    answer = Math.max(answer, num);
                    
                }
                
            }
            else i++;
    
        }
        
        return answer;
    }
} 
 */
