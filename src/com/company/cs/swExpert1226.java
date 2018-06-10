package com.company.cs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
 
/**
 * 
  미로 1  
 *
 */
public class swExpert1226 {
 
    public static char [][] map = new char[16][16];
    public static int [][] visited = new int[16][16];
    public static int [] dxArr = {1,-1,0,0};
    public static int [] dyArr = {0,0,1,-1};
    public static class Point {
        int dx,dy;
        char flag;
        public Point(int x, int y,char f)
        {
            dx= x;dy = y;flag=f;
        }
    }
    public static void init() {
        for(int i =0; i< map.length; i++)
            for(int j=0; j<map.length; j++)
                visited[i][j] =0;
    }
    public static int bfs(int startX, int startY) {
        Queue<Point> que = new LinkedList<Point>();
        que.offer(new Point(startX,startY,'2'));
         
        visited[1][1] = 1;
        int flag = 0;
        while(!que.isEmpty()) {
            Point cur = que.poll();
             
            if(map[cur.dx][cur.dy]== '3') { // 도착점  
                flag =1;break;
            }
            for(int i=0; i<4; i++)
            {
                int cx = cur.dx + dxArr[i];
                int cy = cur.dy + dyArr[i];
                if(map[cx][cy] !='1' && visited[cx][cy] != 1 && cx >= 0 && cy >= 0 && cx < 16 && cy < 16)
                {
                    que.offer(new Point(cx,cy,map[cx][cy]));
                    visited[cx][cy] =1;
                }
            }
        }
        return flag;
    }
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for(int k=1; k<= 10; k++)
        {
            int testCase = Integer.parseInt(reader.readLine());
            int startX=0,startY=0;
            String input;
            for(int i=0; i< map.length; i++) //전체 입력 
            {
                input = reader.readLine();
                for(int j=0; j< input.length(); j++)
                {
                    char end = input.charAt(j);
                    if (end == '2') {
                        startX = i;
                        startY = j;
                    }
                    map[i][j] = end;
                }
            }
            init(); // 초기화  
            int result= bfs(startX,startY);
            System.out.println("#"+k+" "+result);
        }
    }
}