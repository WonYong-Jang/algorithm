package com.company.leetcode;

public class leetcode873 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    public int lenLongestFibSubseq(int[] A) {
        
        return solve(A);
    }
    public int solve(int[] A) {
        
        int len = A.length, answer = 0;
        Arrays.sort(A);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i= len-1; i >= 0; i--) {
            
            map.put(A[i], i);
        }
        
        int cnt = 0;
        for(int i = 0; i < len-2 ; i++) {
            for(int j = i+1; j< len-1; j++) {
                
                int sum = A[i]+ A[j];
                int prev = A[j];
                cnt = 2;
                while(true) {
                    
                    if(!map.containsKey(sum)) break;
                    
                    cnt++;
                    answer = Math.max(answer, cnt);
                    int idx = map.get(sum);
                    
                    sum = prev + A[idx];
                    prev = A[idx];
                }
                
            }
        }
        
            
        return answer;    
    }
} 
 */
