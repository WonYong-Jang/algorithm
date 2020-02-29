package com.company.leetcode;

public class leetcode733 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    public static int row, col;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int target = image[sr][sc];
        row = image.length;
        col = image[0].length;
        int[][] visit = new int[row][col];
        
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(sr,sc));
        image[sr][sc] = newColor;
        
        
        int[] dxArr = {0, 0, 1, -1}, dyArr = {1, -1, 0, 0};
        
        while(!que.isEmpty())
        {
            Node cur = que.poll();
            
            for(int i=0; i< 4; i++)
            {
                int rdx = dxArr[i] + cur.dx;
                int rdy = dyArr[i] + cur.dy;
                if(!isRange(rdx,rdy) || visit[rdx][rdy] == 1) continue;
                if(image[rdx][rdy] == target) {
                    que.add(new Node(rdx,rdy));
                    visit[rdx][rdy] = 1;
                    image[rdx][rdy] = newColor;
                }
            }
            
        }
        
        return image;
    }
    public static boolean isRange(int dx, int dy)
    {
        return dx >= 0 && dy >= 0 && dx < row && dy < col;
    }
    static class Node {
        int dx, dy;
        Node(int a, int b) {
            dx = a; dy = b;
        }
    }
}
 */ 