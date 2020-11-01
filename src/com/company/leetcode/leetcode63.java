package com.company.leetcode;

public class leetcode63 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }    
}
/**
class Solution {
    public int[][] dp;
    public int row, col;
    public int[] dxArr = {0, 1}, dyArr ={1, 0};
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        return solve(obstacleGrid);
    }
    public int solve(int[][] grid) {
        
        row = grid.length;
        if(row == 0) return 0;
        col = grid[0].length;
        
        dp = new int[row][col];
        
        return search(grid, 0, 0);
    }
    public int search(int[][] grid, int dx, int dy) {
        
        if(grid[dx][dy] == 1) return 0;
        else if(dx == row-1 && dy == col-1) return 1;
        else if(dp[dx][dy] > 0) return dp[dx][dy];
        else {
            
            int rdx = 0, rdy = 0, sum = 0;
            for(int i=0; i< 2; i++) {
                
                rdx = dx + dxArr[i];
                rdy = dy + dyArr[i];
                if(!isRange(rdx,rdy) || grid[rdx][rdy] == 1) continue;
                sum += search(grid, rdx, rdy);
            }
            return dp[dx][dy] = sum;
        }
        
    }
    public boolean isRange(int dx, int dy) {
        return dx >= 0 && dy >= 0 && dx < row && dy < col;
    }
}
 */
