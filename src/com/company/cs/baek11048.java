package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 이동하기 
 */
public class baek11048 {

	static int[][] map = new int[1005][1005];
	static int[][] dis = new int[1005][1005];
	static int N, M;
	static int[] dxArr = {1, 0, 1};
	static int[] dyArr = {0, 1, 1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<= M; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve();
		
		bw.write(dis[N][M]+"\n");
		bw.flush();
	}
	public static void solve()
	{
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= M; j++)
			{
				dis[i][j] = -1;
			}
		}
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(1,1));
		dis[1][1] = map[1][1];
		
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			for(int i=0; i<3; i++)
			{
				int nx = n.dx + dxArr[i];
				int ny = n.dy + dyArr[i];
				if(!isRange(nx, ny)) continue;
				if(dis[nx][ny] == -1 || dis[nx][ny] < dis[n.dx][n.dy] + map[nx][ny])
				{
					dis[nx][ny] = dis[n.dx][n.dy] + map[nx][ny];
					que.add(new Node(nx,ny));
				}
				
			}
		}
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >=1 && dy >= 1 && dx <= N && dy <= M;
	}
	public static int max(int a, int b) 
	{
		return a > b ? a : b;
	}
	static class Node{
		int dx,dy;
		Node(int x, int y) {
			dx = x; dy = y;
		}
	}
}




