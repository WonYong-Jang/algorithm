package com.company.leetcode;

public class leetcode1351 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
}
/**
class Solution {
    public int countNegatives(int[][] grid) {
        
        return solve(grid);
    }
    public int solve(int[][] grid) {
        
        int answer = 0;
        int row = grid.length;
        int col = grid[0].length;
        
        for(int i=0; i< row; i++) {
            
            int idx = search(grid, i, col, -1);
            answer += (col - idx);
            
        }
        return answer;
    }
    public int search(int[][]grid, int row, int col, int target) {
        
        int mid = 0;
        int s = 0, e = col;
        
        while(s < e) {
            
            mid = s + ( e - s) / 2;
            
            if(grid[row][mid] <= target) {
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
