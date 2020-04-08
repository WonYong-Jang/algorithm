package com.company.hackerRank;

public class hRank_CastleOntheGrid {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumMoves function below.
    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
        Queue<Node> que = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length();
        char[][] map = new char[row][col];
        int[] dxArr = {-1, 0, 1, 0}, dyArr ={0, 1, 0, -1};
        int[][] visit = new int[row][col];
        for(int i=0; i<row; i++){
            
            char[] tmp = grid[i].toCharArray();
            for(int j=0; j<col; j++) {
                visit[i][j] = -1;
                map[i][j] = tmp[j];
            }
        }
        visit[startX][startY] = 0;
        que.add(new Node(startX,startY));
        
        while(!que.isEmpty()){
            Node cur = que.poll();
            if(cur.dx == goalX && cur.dy == goalY) break;
            int num = visit[cur.dx][cur.dy] + 1;
            
            for(int i=0; i< 4; i++) {

                int rdx = cur.dx, rdy = cur.dy;
                while(true) {
                    
                    rdx += dxArr[i];
                    rdy += dyArr[i];
                    if(!isRange(rdx,rdy,row,col) || map[rdx][rdy] == 'X' ) break;
                    if(visit[rdx][rdy] == -1 ) {
                        visit[rdx][rdy] = num;
                        que.add(new Node(rdx,rdy));
                    }
                }
            }

        }

        return visit[goalX][goalY];
    }
    static boolean isRange(int dx, int dy, int row, int col) {
        return dx>=0 && dy>=0 && dx< row && dy < col;
    }
    static class Node {
        int dx, dy;
        Node(int a, int b) {
            dx=a; dy=b;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] startXStartY = scanner.nextLine().split(" ");

        int startX = Integer.parseInt(startXStartY[0]);

        int startY = Integer.parseInt(startXStartY[1]);

        int goalX = Integer.parseInt(startXStartY[2]);

        int goalY = Integer.parseInt(startXStartY[3]);

        int result = minimumMoves(grid, startX, startY, goalX, goalY);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
 
 */
