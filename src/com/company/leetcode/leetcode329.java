package com.company.leetcode;
/**
 * 
 * @author jang-won-yong
 * 329. Longest Increasing Path in a Matrix
 */
public class leetcode329 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
       
    }
}

class Solution {
    public int row, col, result;
    public int[][] visit;
    public int[][] map;
    public int[] dxArr = {0, 0, 1, -1}, dyArr = {1, -1, 0, 0};
    public int longestIncreasingPath(int[][] matrix) {
        
        if(matrix == null || matrix.length == 0 || matrix[0].length ==0 ) return 0;
        
        result = 0;
        row = matrix.length;
        col = matrix[0].length;
        visit = new int[row][col];
        map = new int[row][col];
        for(int i=0; i < row; i++)
        {
            for(int j=0; j < col; j++)
            {
                visit[i][j] = -1;
                map[i][j] = matrix[i][j];
            }
        }
        
        for(int i=0; i < row; i++)
        {
            for(int j=0; j< col; j++)
            {
                dfs(i, j);
            }
        }
        
        return result;
    }
    public int dfs(int dx, int dy)
    {
        
        if(visit[dx][dy] != -1) return visit[dx][dy];
        
        visit[dx][dy] = 1;
        int num = 0;
        for(int i = 0; i < 4; i++)
        {
            int rdx = dxArr[i] + dx;
            int rdy = dyArr[i] + dy;
            if(!isRange(rdx,rdy)) continue;
            
            if( map[rdx][rdy] >= map[dx][dy] ) continue;   
            
            num = max(num, dfs(rdx, rdy));
        }
        visit[dx][dy] += num;
        result = max(result,visit[dx][dy]);
        return visit[dx][dy];
    }
    public int max(int a, int b) { return a > b ? a : b ;}
    public boolean isRange(int dx, int dy)
    {
        return dx >=0 && dy >= 0 && dx < row && dy < col;
    }
}