package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 구슬탈출 2  
 *
 */
public class baek13460 {
	
	// 0 : 오른 /  1 : 위쪽  /  2 : 왼쪽  /  3  : 아래쪽   
	public static char[][] map = new char[11][11];
	public static char[][][] originMap = new char[11][11][11];
	public static int N, M;
	public static Point B ,R, dest;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=1; i<= N; i++)
		{
			String str = br.readLine();
			for(int j=1; j<= M; j++)
			{
				char temp =str.charAt(j-1);
				originMap[0][i][j]= map[i][j] = temp; // input 
				if(temp == 'B') B = new Point(i,j);
				else if(temp == 'R') R = new Point(i,j);
				else if(temp == 'O') dest = new Point(i,j);
			}
		}
		
		move(2,1);
		
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= M; j++)
			{
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	public static void move(int dir, int depth) // 방향 별로 이동   
	{
		if(dir == 0) { // 오른쪽  
			
		}
		else if( dir ==1 ) // 위쪽  
		{
			
		}
		else if(dir == 2 ) // 왼쪽으로 이동할때 
		{
			for(int i=2; i< N; i++)
			{
				for(int j=2; j<M; j++)
				{
					//if(map[i][j] == 'B' || map[i][j] == 'R') 
				}
			}
		}
		else if( dir ==3 ) // 아래쪽  
		{
			
		}
	}
	
	public static class Point {
		int dx,dy;
		Point(int x, int y) {
			dx = x; dy =y;
		}
	}
}
