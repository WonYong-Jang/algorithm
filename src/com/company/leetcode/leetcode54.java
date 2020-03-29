package com.company.leetcode;

public class leetcode54 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }   
}
/**
class Solution {
    
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        
        int[] dxArr = {0, 1, 0, -1}, dyArr = {1, 0, -1, 0};
        int row = matrix.length;
        if(row == 0) return ans;
        int col = matrix[0].length;
        
        int[][] visit = new int[row][col];
        
        int axis = 0, cnt = 0;
        int dx = 0, dy = 0;
        ans.add(matrix[dx][dy]);
        visit[dx][dy] = 1;
        while(true)
        {
            if(cnt == row*col - 1) break;
            int rdx = dx + dxArr[axis];
            int rdy = dy + dyArr[axis];
            System.out.println(rdx+ " " + rdy+ " "+ cnt);
            if(rdx >= row || rdy >= col || rdx < 0 || rdy < 0 || visit[rdx][rdy] == 1) {
                axis = (axis + 1) % 4;
                continue;
            }
            dx = rdx; dy = rdy;
            visit[rdx][rdy] = 1;
            cnt++;
            ans.add(matrix[rdx][rdy]);
            
        }
            
        return ans;
    }
}
*/
