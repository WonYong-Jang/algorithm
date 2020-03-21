package com.company.leetcode;

public class leetcode744 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    public static int[] data;
    public char nextGreatestLetter(char[] letters, char target) {
        
        int len = letters.length;
        data = new int[len];
        for(int i=0; i< len; i++) {
            data[i] = letters[i] - 'a';
        }
        
        int ans = upper_bound(0, len, target - 'a');
        if(ans == len) return letters[0];
        else return letters[ans];
    }
    public static int upper_bound(int s, int e, int target) {
        
        int mid = 0;
        while(s < e) {
            mid = s + (e - s) / 2;
            if(data[mid] > target) {
                e = mid;
            }
            else {
                s = mid + 1;
            }
        }
        
        return e;
    }
} 
 */
