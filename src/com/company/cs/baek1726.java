package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 로봇 
 */
public class baek1726 {

	static int N, M;
	static int sdx, sdy, sdir, edx, edy, edir;
	static int left, right; // 현재 방향 기준 
	static int[][] map = new int[105][105];
	static int[][][] visit = new int[4][105][105];
	static Queue<Node> que = new LinkedList<>();
	static int[] dxArr = {0, 0, 1, -1}, dyArr = {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		init(); // 초기화 
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<= M; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		sdx = Integer.parseInt(st.nextToken());
		sdy = Integer.parseInt(st.nextToken());
		sdir = Integer.parseInt(st.nextToken())-1;
		st = new StringTokenizer(br.readLine());
		edx = Integer.parseInt(st.nextToken());
		edy = Integer.parseInt(st.nextToken());
		edir = Integer.parseInt(st.nextToken())-1;
		
		solve();
	}
	public static void solve()
	{
		que.add(new Node(sdx, sdy, sdir));
		visit[sdir][sdx][sdy] = 0;
		
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			if(n.dx == edx && n.dy == edy && n.dir == edir)
			{
				System.out.println(visit[n.dir][n.dx][n.dy]);
				break;
			}
			
			int nx = n.dx, ny = n.dy;
			for(int i=0; i< 3; i++)
			{
				nx += dxArr[n.dir];
				ny += dyArr[n.dir];
				if(!isRange(nx, ny) || map[nx][ny] == 1) break;
				
				if(visit[n.dir][nx][ny] == -1) // 앞으로 전진 확인 / 방문한적이 없다면 
				{
					visit[n.dir][nx][ny] = visit[n.dir][n.dx][n.dy] + 1;
					que.add(new Node(nx, ny, n.dir));
				}
			}
			direction(n.dir); 
			
			if(visit[left][n.dx][n.dy] == -1)
			{
				visit[left][n.dx][n.dy] = visit[n.dir][n.dx][n.dy] + 1; // 해당 방향에서 회전 
				que.add(new Node(n.dx, n.dy, left));
			}
			
			if(visit[right][n.dx][n.dy] == -1)
			{
				visit[right][n.dx][n.dy] = visit[n.dir][n.dx][n.dy] + 1; // 해당 방향에서 회전 
				que.add(new Node(n.dx, n.dy, right));
			}
		}
	}
	public static void direction(int dir) // 해당 방향에서 왼쪽 오른쪽 정해줌 
	{
		switch(dir)
		{
		case 0: left=3; right=2; break;
		case 1: left=2; right=3; break;
		case 2: left=0; right=1; break;
		case 3: left=1; right=0; break;
		}
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx>=1 && dy>=1 && dx<= N && dy <= M;
	}
	public static void init()
	{
		for(int k=0; k<4; k++)
			for(int i=1; i<= N; i++)
				for(int j=1; j<= M; j++)	
					visit[k][i][j] = -1;
	}
	static class Node{
		int dx, dy, dir;
		Node(int a, int b, int c){
			dx=a; dy=b; dir=c;
		}
	}
}
