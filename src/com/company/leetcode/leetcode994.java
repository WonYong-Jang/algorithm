package com.company.leetcode;

public class leetcode994 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }    
}
/**
class Solution {
    public static int row, col;
    public int orangesRotting(int[][] grid) {
        
        row = grid.length;
        col = grid[0].length;
        int[] dxArr = {0, 0 ,1, -1}, dyArr = {1, -1, 0, 0}; 
        int[][] visit = new int[row][col];
        int refreshNum = 0;
        Queue<Node> que = new LinkedList<>();
        for(int i=0; i< row; i++) {
            for(int j=0; j < col; j++) {
                if(grid[i][j] == 2) {
                    que.add(new Node(i,j,0));
                    visit[i][j] = 1;
                }
                else if(grid[i][j] == 1) refreshNum++;
            }
        }
        
        int ans = 0;
        while(!que.isEmpty()) {
            Node cur = que.poll();
            ans = Math.max(ans, cur.cnt);
            
            for(int i=0; i< 4; i++) {
                int rdx = cur.dx + dxArr[i];
                int rdy = cur.dy + dyArr[i];
                if(!isRange(rdx, rdy) || visit[rdx][rdy] == 1) continue;
                if(grid[rdx][rdy] == 1) {
                    visit[rdx][rdy] = 1;
                    refreshNum--;
                    que.add(new Node(rdx,rdy,cur.cnt+1));
                }
            }
        }
        
        if(refreshNum > 0) return -1;
        else return ans;
    }
    public static boolean isRange(int dx, int dy) {
        return dx >=0 && dy >=0 && dx < row && dy < col;
    }
    static class Node {
        int dx, dy, cnt;
        Node(int a, int b, int c) { 
            dx = a; dy = b; cnt = c;
        }
    }
} 
 */
