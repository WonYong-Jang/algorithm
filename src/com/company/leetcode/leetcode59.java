package com.company.leetcode;

public class leetcode59 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    public int[] dxArr ={0, 1, 0, -1}, dyArr = {1, 0, -1, 0};
    public int[][] generateMatrix(int n) {
        
        return solve(n);
    }
    public int[][] solve(int n) {
        
        int[][] data = new int[n][n];
        
        search(data, 0, 0, n, 0, 1);
        
        return data;
    }
    public void search(int[][] data, int dx, int dy, int n, int axis, int val) {
        
        if(!isRange(dx, dy, n) || data[dx][dy] > 0) return;
        
        data[dx][dy] = val;
        int rdx = dx + dxArr[axis];
        int rdy = dy + dyArr[axis];
        
        if(!isRange(rdx, rdy, n) || data[rdx][rdy] > 0) {
            axis = (axis+1) % 4;
            rdx = dx + dxArr[axis];
            rdy = dy + dyArr[axis];
        }
        
        search(data, rdx, rdy, n, axis, val+1);
        
    }
    public boolean isRange(int dx, int dy, int n) {
        
        return dx>=0 && dy >=0 && dx < n && dy < n;
    }
} 
 */
