package com.company.leetcode;

public class leetcode11 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    
    public int len, answer;
    public int maxArea(int[] height) {
        
        len = height.length;
        answer = 0;
        
        int start = 0, end = len-1;
        
        while(start < end)
        {
            int sum = 0;
            if(height[start] < height[end]) {
                sum = (height[start])*(end-start);
                start++;
            }
            else {
                sum = (height[end])*(end-start);
                end--;
            }
            answer = max(answer, sum);
        }
        
        
        return answer;
    }
   
    public int min(int a, int b) { return a > b ? b : a ;}
    public int max(int a, int b) { return a > b ? a : b ;}
}
**/
