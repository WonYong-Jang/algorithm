package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek7569 {

	static int M, N, H;
	static int[][][] data = new int[105][105][105];
	static int[][][] visit = new int[105][105][105];
	static int[] dxArr = {0, 0, 1, -1}, dyArr= {1, -1, 0, 0};
	static Queue<Node> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 순서 변경 
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		for(int k=1; k<= H; k++)
		{
			for(int i=1; i<= M; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<= N; j++)
				{
					data[k][i][j] = Integer.parseInt(st.nextToken());
					visit[k][i][j] = -1;
				}
			}
		}
		for(int k=1; k<= H; k++)
		{
			for(int i=1; i<= M; i++)
			{
				for(int j=1; j<= N; j++)
				{
					if(visit[k][i][j] == 1 || data[k][i][j] != 1) continue;
					solve(k, i, j);
					
				}
			}
		}
		for(int k=1; k<= H; k++)
		{
			for(int i=1; i<= M; i++)
			{
				for(int j=1; j<= N; j++)
				{
					System.out.print(visit[k][i][j]+" ");
				}
				System.out.println();
			}
		}
		result();
	}
	public static void result()
	{
		int temp =0;
		for(int k=1; k<= H; k++)
		{
			for(int i=1; i<= M; i++)
			{
				for(int j=1; j<= N; j++)
				{
					if(data[k][i][j] == -1) continue;
					if(visit[k][i][j] == -1) 
					{
						System.out.println(-1);
						return;
					}
					temp = max(temp, visit[k][i][j]);
				}
			}
		}
		System.out.println(temp);
	}
	public static void solve(int h, int dx, int dy)
	{
		visit[h][dx][dy] = 0;
		que.add(new Node(h,dx,dy));
		
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			for(int i=0; i<4; i++) // 상하좌우 
			{
				int nx = n.dx + dxArr[i];
				int ny = n.dy + dyArr[i];
				if(!isRange(nx,ny) || visit [n.height][nx][ny] != -1 || data[n.height][nx][ny] == -1) continue;
				que.add(new Node(n.height, nx, ny));
				visit [n.height][nx][ny] = visit [n.height][n.dx][n.dy] + 1;
			}
			if(n.height + 1 <= H && visit [n.height+1][n.dx][n.dy] == -1)
			{
				visit [n.height+1][n.dx][n.dy] = visit [n.height][n.dx][n.dy] + 1;
				que.add(new Node(n.height+1, n.dx, n.dy));
			}
			else if(n.height - 1 >= 1 && visit [n.height-1][n.dx][n.dy] == -1)
			{
				visit [n.height-1][n.dx][n.dy] = visit [n.height][n.dx][n.dy] + 1;
				que.add(new Node(n.height-1, n.dx, n.dy));
			}
		}
	}
	public static int max(int a, int b)
	{
		return a > b? a: b;
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >= 1 && dy >= 1 && dx <= M && dy <= N;
	}
	static class Node {
		int dx, dy, height;
		Node(int a, int b, int c) {
			height = a; dx = b; dy = c; 
		}
	}
}
