package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 미로 2 
 *
 */
public class swExpert1227 {
	public static class Point {
		int dx, dy;
		Point(int x, int y) {
			dx =x; dy =y;
		}
	}
	public static final int N = 100;
	public static char[][] map = new char[101][101];
	public static int[] dxArr = {1, -1, 0, 0};
	public static int[] dyArr = {0, 0, -1, 1};
	public static Point start, end;
	
	public static int bfs() {
		Queue<Point> que = new LinkedList<>();
		int flag =0;
		que.offer(start);
		map[start.dx][start.dy] = '1';
		while(!que.isEmpty()) {
			Point curPoint = que.peek();
			que.poll();
			if(curPoint.dx == end.dx && curPoint.dy == end.dy) flag =1;
			for(int i=0; i<4; i++)
			{
				int rDx = dxArr[i] + curPoint.dx;
				int rDy = dyArr[i] + curPoint.dy;
				if(rDx >= 1 && rDy >=1 && rDx <= 100 && rDy <= 100 && map[rDx][rDy] != '1' ) {
					que.offer(new Point(rDx, rDy));
					map[rDx][rDy] = '1';
				}
			}
		}
		if(flag == 0 ) return 0;
		else return 1;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		for(int k =1; k<=10; k++)
		{
			int next = Integer.parseInt(reader.readLine());
			
			for(int i=1; i<= N; i++) // input 
			{
				String input = reader.readLine();
				for(int j=1; j<= N; j++)
				{
					char chkNum = input.charAt(j-1);
					map[i][j] = chkNum;
					if(chkNum == '2') {
						start = new Point(i,j);
					}
					else if(chkNum == '3') {
						end = new Point(i,j);
					}
				}
			}
			int result = bfs();
			System.out.println("#" + k + " " + result);
		}
	}

}
