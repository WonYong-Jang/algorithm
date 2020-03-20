package com.company.programmers;

public class pro42584 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        int len = prices.length;
        for(int i=0; i< len; i++) {
            int cnt = 0;
            for(int j= i+1; j< len; j++) {
                if(prices[i] > prices[j]) {
                    cnt++;
                    break;
                }
                else cnt++;
            }
            answer[i] = cnt;
        }
        return answer;
    }
} 
 */
