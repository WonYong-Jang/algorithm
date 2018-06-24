package com.company.sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [모의 SW 역량테스트 ] 탈주범 검거  
 */
public class swExpert1953 {

	public static int N, M, R, C, L, resultCnt;
	public static int[][] map = new int[51][51];
	public static int[][] visited = new int[51][51];
	public static int[] dxArr = {0, 1, 0, -1 }; // 오른쪽, 아래 , 왼쪽 , 위쪽 순서  
	public static int[] dyArr = {1, 0, -1, 0 };
	public static int[] type= {15, 10, 5, 9, 3, 6, 12}; // 1 ~ 7 
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken()); // 맨홀 
			C = Integer.parseInt(st.nextToken()); // 맨홀  
			L = Integer.parseInt(st.nextToken()); // 소요시간  
			
			for(int i=0; i< N; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=0; j< M; j++)
				{
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			init();
			bfs();
			System.out.println("#"+k+" "+resultCnt);
			
		}
	}
	public static void bfs()
	{
		Queue<Point> que = new LinkedList<>();
		int rDx =0, rDy=0;
		que.add(new Point(R, C, 1));
		visited[R][C] = 1;
		while(!que.isEmpty()) 
		{
			int dx = que.peek().dx;
			int dy = que.peek().dy;
			int time = que.peek().time;
			que.poll();
			if(time > L) break; 
			resultCnt++;
			int typeIndex = map[dx][dy] -1;
			int tunel = type[typeIndex];
			
			for(int i=0; i<4; i++)
			{
				if( (tunel & ( 1<<i)) >0) 
				{
					rDx = dx + dxArr[i];
					rDy = dy + dyArr[i];
					if(rDx>=0 && rDy>=0 && rDx < N && rDy < M && visited[rDx][rDy] == 0 &&
							map[rDx][rDy] > 0)
					{
						if(chkConnect(i, rDx, rDy))
						{
							que.add(new Point(rDx,rDy,time+1));
							visited[rDx][rDy] = 1;
						}
					}
					
				}
			}
			
			
		}
	}
	public static boolean chkConnect(int dir,int dx,int dy)
	{
		int result =0, flag =0;
		int typeIndex = map[dx][dy] -1;
		int tunel = type[typeIndex];
		
		switch(dir)
		{
		case 0:result=2;break;
		case 1:result=3;break;
		case 2:result=0;break;
		case 3:result=1;break;
		}
		for(int i=0; i<4; i++)
		{
			if( (tunel & (1 << i)) > 0 )
			{
				if(i == result) flag = 1;
			}
		}
		if(flag == 1) return true; // 연결 된 부분이 있다면 true 
		else return false;
	}
	public static void init() {
		resultCnt =0;
		for(int i=0; i< N; i++) {
			for(int j=0; j< M; j++) {
				visited[i][j] =0;
			}
		}
	}
	public static class Point {
		int dx,dy, time;
		Point(int x, int y, int z) {
			dx =x; dy =y; time =z;
		}
	}
}
