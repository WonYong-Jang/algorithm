package com.company.programmers;

public class pro43237 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    public int solution(int[] budgets, int M) {
        int answer = 0, N = budgets.length;
        
        long target = (long)M;
        int s = 1, e = 0;
        for(int i=0; i< N; i++) {
            e = Math.max(e, budgets[i]);
        }
        
        while(s <= e)
        {
            int mid = s + (e - s) / 2;
            long sum = 0;
            for(int i = 0; i < N; i++) {
                if(mid <= budgets[i]) sum += (long)mid;
                else sum += (long)budgets[i];
            }
            
            if(sum <= target) {
                answer = mid;
                s = mid + 1;
            }
            else e = mid - 1;
        }
        
        return answer;
    }
} 
 */
