package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 토마토 (토마토가 다 익는데 걸리는 시간 )
 */
public class baek7569 {
	
	
	static int M, N, H, ans;
	static Queue<Node> que = new LinkedList<>();
	static int[] dxArr = {0, 0, 1, -1}, dyArr = {1, -1, 0, 0};
	static int[][][] map = new int[101][101][101]; // H, M, N
	static int[][][] visit = new int[101][101][101]; // H, M, N
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		ans = 0;
		for(int k=1; k<= H; k++)
		{
			for(int i=1; i<= M; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<= N; j++)
				{
					map[k][i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		for(int k=1; k<= H; k++)
		{
			for(int i=1; i<= M; i++)
			{
				for(int j=1; j<= N; j++)
				{
					if(map[k][i][j] == 1)
					{
						que.add(new Node(k, i, j, 0));
						visit[k][i][j] = 1;
					}
				}
			}
		}
		solve();
		print();
	}
	public static void print()
	{
		for(int k=1; k<= H; k++)
		{
			for(int i=1; i<= M; i++)
			{
				for(int j=1; j<= N; j++)
				{
					if(map[k][i][j] == -1) continue;
					if(visit[k][i][j] == 0)
					{
						System.out.println(-1);
						return;
					}
				}
			}
		}
		System.out.println(ans);
	}
	public static void solve()
	{
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			ans = max(ans, n.cnt); // 가장 긴 시간 
			
			for(int i=0; i<4; i++) // 4방향 
			{
				int nx = n.dx + dxArr[i];
				int ny = n.dy + dyArr[i];
				if(!isRange(n.height ,nx, ny) || visit[n.height][nx][ny] == 1 ) continue;
				if(map[n.height][nx][ny] == 0)
				{
					visit[n.height][nx][ny] = 1; // 방문 표시
					que.add(new Node(n.height, nx, ny, n.cnt+1));
				}
			}
			if(isRange(n.height+1, n.dx, n.dy) && visit[n.height+1][n.dx][n.dy] != 1)
			{
				if(map[n.height+1][n.dx][n.dy] == 0)
				{
					visit[n.height+1][n.dx][n.dy] = 1; // 방문 표시
					que.add(new Node(n.height+1, n.dx, n.dy, n.cnt+1));
				}
			}
			if(isRange(n.height-1, n.dx, n.dy) && visit[n.height-1][n.dx][n.dy] != 1)
			{
				if(map[n.height-1][n.dx][n.dy] == 0)
				{
					visit[n.height-1][n.dx][n.dy] = 1; // 방문 표시
					que.add(new Node(n.height-1, n.dx, n.dy, n.cnt+1));
				}
			}
		}
	}
	public static boolean isRange(int h,int dx, int dy)
	{
		return dx>=1 && dy>=1 && dx<= M && dy <= N && h >= 1 && h <= H;
	}
	public static int max(int a, int b)
	{
		return a > b? a : b;
	}
	static class Node {
		int height ,dx, dy, cnt; // cnt : 시간 계산 
		Node(int a, int b, int c, int d) {
			height = a; dx = b; dy = c; cnt = d;
		}
	}
}

/**
5 3 1
1 0 -1 0 0
-1 -1 0 1 1
0 0 0 1 1
 */
