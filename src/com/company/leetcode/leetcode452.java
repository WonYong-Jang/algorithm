package com.company.leetcode;

public class leetcode452 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    public int findMinArrowShots(int[][] points) {
        
        int len = points.length;
        
        if(len == 0) return 0;
        
        Comparator<int[]> mySort = new Comparator<int[]>() {
            public int compare(int[] a, int [] b) {
                return a[1] - b[1];
            }
        };
        
        Arrays.sort(points, mySort);
        
        int axis = points[0][1];
        int answer = 1;
        for(int i=1; i< len; i++) {
            
            int start = points[i][0];
            int end = points[i][1];
            
            if(start <= axis && axis <= end) continue;
            axis = end;
            answer++;
        }
        
        
        return answer;
    }
    
} 
 */
