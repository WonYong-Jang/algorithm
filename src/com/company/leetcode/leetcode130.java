package com.company.leetcode;

public class leetcode130 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    int[][] visit;
    int row, col;
    int[] dxArr = {0, 0, 1, -1};
    int[] dyArr = {1, -1, 0, 0};
    public void solve(char[][] board) {
        
        row = board.length;
        if(row == 0) return;
        col = board[0].length;
        visit = new int[row][col];
        
        for(int i=0; i< row; i++) {
            for(int j=0; j<col; j++) {
                if(visit[i][j] == 1) continue;
                if(board[i][j] == 'O') {
                    search(i, j, board);     
                }
            }
        }
            
    }
    public void search(int dx, int dy, char[][]board) {
        
        Queue<Node> flip = new LinkedList<>();
        Queue<Node> que = new LinkedList<>();
        boolean flag = true;
        que.offer(new Node(dx, dy));
        flip.offer(new Node(dx, dy));
        while(!que.isEmpty()) {
            Node cur = que.poll();
            
            for(int i=0; i< 4; i++) {
                int rdx = cur.dx + dxArr[i];
                int rdy = cur.dy + dyArr[i];
                
                if(!isRange(rdx,rdy)) {
                    flag = false;
                    continue;
                }
                
                if(visit[rdx][rdy] == 1 || board[rdx][rdy] == 'X') continue;
                
                visit[rdx][rdy] = 1;
                que.offer(new Node(rdx,rdy));
                flip.offer(new Node(rdx,rdy));
            }
        }
        if(!flag) return;
        while(!flip.isEmpty()) {
            Node cur = flip.poll();
            
            board[cur.dx][cur.dy] = 'X';
        }
        
    }
    public boolean isRange(int dx, int dy) {
        return dx >= 0 && dy >=0 && dx < row && dy < col;
    }
    public class Node{
        int dx, dy;
        Node(int a, int b) {
            dx=a; dy=b;
        }
    }
}








 
 */
