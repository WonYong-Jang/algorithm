package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 토마토. 
 */
public class baek7576 {

	static int M, N, ans;
	static int[][] map = new int[1005][1005];
	static int[][] visit = new int[1005][1005];
	static Queue<Node> que = new LinkedList<>();
	static int[] dxArr = {0, 0, 1, -1}, dyArr = {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int temp =0; 
		ans = 0;
		for(int i= 1; i<= M; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<= N; j++)
			{
				temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if(temp == 1)
				{
					que.add(new Node(i,j,0));
					visit[i][j] = 1; // 방문 표시 
				}
			}
		}
		solve();
		print();
	}
	public static void print()
	{
		for(int i=1; i<= M; i++)
		{
			for(int j=1; j<= N; j++)
			{
				if(map[i][j] == -1) continue;
				if(visit[i][j] == 0 )
				{
					System.out.println(-1);
					return;
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
			
			ans = max(ans, n.cnt);
			
			for(int i=0; i<4; i++)
			{
				int nx = n.dx + dxArr[i];
				int ny = n.dy + dyArr[i];
				if(!isRange(nx, ny) || visit[nx][ny] == 1 || map[nx][ny] == -1) continue;
				
				visit[nx][ny] = 1;
				que.add(new Node(nx, ny, n.cnt+1));
			}
			
		}
	}
	public static int max(int a, int b)
	{
		return a > b ? a: b;
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx>=1 && dy>=1 && dx<= M && dy<= N;
	}
	static class Node {
		int dx, dy, cnt;
		Node(int x, int y, int z) {
			dx = x; dy = y; cnt =z;
		}
	}
}
