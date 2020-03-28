package com.company.leetcode;

public class leetcode167 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    public int[] data;
    public int[] twoSum(int[] numbers, int target) {
        
        int[] answer = new int[2];
        data = numbers;
        int len = numbers.length;
        
        for(int i=0; i< len-1; i++) {
            int value = target - numbers[i];
            
            int result = search(i+1, len-1, value);
            if(result == -1) continue;
            
            answer[0] = i+1;
            answer[1] = result+1;
            break;
        }
        
        
        
        return answer;
    }
    public int search(int s, int e, int target) {
        
        while(s <= e) {
            int mid = (s + e) / 2;
            if(data[mid] == target) return mid;
            else if(data[mid] < target) s = mid+1;
            else e = mid-1;
        }
        
        return -1;
    }
} 
 */
