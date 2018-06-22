package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 구슬탈출 2  
 */
public class baek13460 {
	 
	public static char[][] map = new char[11][11];
	public static int[][][][] visited = new int[11][11][11][11];
	public static int N, M;
	public static int[] dx = {0, -1, 0, 1}, dy = {-1, 0, 1, 0};
	public static int srx,sry,sbx,sby; // red, blue 시작 점  
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
				map[i][j] = temp; // input 
				if(temp == 'B') {
					sbx =i; sby =j;
				}
				else if(temp == 'R') {
					srx =i; sry =j;
				}
			}
		}
		solve();
	}
	public static void solve() {
		Queue<Point> que = new LinkedList<>();
		que.add(new Point(srx,sry,sbx,sby,0));
		visited[srx][sry][sbx][sby]=1;
		int rDx=0, rDy=0, bDx=0, bDy=0;
		int redFlag =0, blueFlag=0, resultCnt =0;
		while(!que.isEmpty())
		{
			Point point = que.poll();
			int rx = point.rx, ry = point.ry;
			int bx = point.bx, by = point.by;
			if(point.cnt > 10) break; // 최대 10 초과시 break;
			resultCnt = point.cnt;
			//System.out.println(rx+" "+ry+" "+bx+" "+by);
			for(int i=0; i<4; i++)
			{
				redFlag =0 ; blueFlag =0;
				rDx = rx; rDy = ry; bDx = bx; bDy =by;
				int back = direction(i); // 해당 방향의 반대 방향 
				while(true) // red 
				{
					rDx += dx[i];
					rDy += dy[i];
					if(rDx < 1 || rDy < 1 || rDx > N || rDy > M) break;
					if(map[rDx][rDy]=='#') {
						rDx += dx[back];
						rDy += dy[back];
						break;
					}
					else if(map[rDx][rDy]=='O') {
						redFlag=1; break;
					}
				}
				
				while(true) // blue
				{
					bDx += dx[i];
					bDy += dy[i];
					if(bDx < 1 || bDy < 1 || bDx > N || bDy > M) break;
					if(map[bDx][bDy] =='#') {
						bDx += dx[back];
						bDy += dy[back];
						break;
					}
					else if(map[bDx][bDy] =='O') {
						blueFlag=1; break;
					}
				}
				// 이동했을때 두 구슬이 겹칠 경우 행 값이 같거나 열 값이 같기때문에 이동 전 좌표를 비교 후 위치 시킴 
				if(rDx == bDx && rDy == bDy)  
				{
					switch(i)
					{
					case 0:
						if(ry > by) rDy += dy[back];
						else bDy += dy[back];
						break;
					case 1:
						if(rx > bx) rDx += dx[back];
						else bDx += dx[back];
						break;
					case 2:
						if(ry > by) bDy += dy[back];
						else rDy += dy[back];
						break;
					case 3:
						if(rx > bx) bDx += dx[back];
						else rDx += dx[back];
						break;
					}
				}
				//System.out.println("result : "+rDx+" "+rDy+" "+bDx+" "+bDy);
				//System.out.println("flag : " + redFlag+" "+blueFlag);
				if(blueFlag == 1) continue; // 파란 구슬이 빠졌을 경우는 무시 (동시에 두 구슬이 빠졌을 경우도 포함) 
				if(redFlag ==1 && blueFlag ==0) {
					resultCnt++;
					break;
				}
				if(rDx >=2 && rDy>=2 && rDx <= N-1 && rDy <= M-1 &&
						bDx >=2 && bDy>=2 && bDx <= N-1 && bDy <= M-1 && visited[rDx][rDy][bDx][bDy] != 1)
				{
					que.add(new Point(rDx,rDy,bDx,bDy,resultCnt+1));
					visited[rDx][rDy][bDx][bDy] = 1;
				}
			}
			if(redFlag == 1 && blueFlag ==0) break; // 빨간 구슬만 빠진 경우는 중지
		}
		
		if(redFlag == 1 && blueFlag ==0 && resultCnt <= 10) System.out.println(resultCnt);
		else System.out.println(-1);
	}
	public static int direction(int dir) { // 해당 방향의 반대 방향 리턴  
		int result =0;
		switch(dir)
		{
		case 0: result=2;break;
		case 1: result=3;break;
		case 2: result=0;break;
		case 3: result=1;break;
		}
		return result;
	}
	public static class Point {
		int rx,ry,bx,by,cnt;
		Point(int a, int b, int c, int d, int e) { // red(a,b)  blue(c,d)
			rx =a; ry=b; bx=c; by =d; cnt =e;
		}
	}
}
