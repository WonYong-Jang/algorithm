package com.company.leetcode;

public class leetcode200 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    int row, col;
    int[][] visit;
    int[] dxArr = {0, 0, 1, -1}, dyArr ={1, -1, 0, 0};
    public int numIslands(char[][] grid) {
        
        int ans = 0;
        row = grid.length;
        if(row == 0) return 0;
        col = grid[0].length;
        visit = new int[row][col];
        
        for(int i=0; i< row; i++) {
            for(int j=0; j< col; j++) {
                if(visit[i][j] == 1) continue;
                if(grid[i][j] == '1') {
                    visit[i][j] = 1;
                    search(i, j, grid);
                    ans++;    
                }
            }
        }
        return ans;
    }
    public void search(int dx, int dy, char[][] grid) {
        
        for(int i=0; i< 4; i++) {
            int rdx = dx + dxArr[i];
            int rdy = dy + dyArr[i];
            if(!isRange(rdx,rdy) || visit[rdx][rdy] == 1) continue;
            if(grid[rdx][rdy] == '1') {
                visit[rdx][rdy] = 1;
                search(rdx,rdy, grid);
            }
        }
        
    }
    public boolean isRange(int dx, int dy) {
        return dx >=0 && dy >=0 && dx < row && dy < col;
    }
} 
 */
