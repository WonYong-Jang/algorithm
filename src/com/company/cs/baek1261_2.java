package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 알고스팟 (다익스트라) 
 */
public class baek1261_2 {

	static int N, M;
	static final int INF = 50000;
	static int[][] map = new int[105][105];
	static int[][] ans = new int[105][105];
	static int[] dxArr = {-1,0,1,0}, dyArr = {0,1,0,-1};
	static PriorityQueue<Node> que = new PriorityQueue<>(new mySort());
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<= N; i++)
		{
			String str = br.readLine();
			for(int j=1; j<= M; j++)
			{
				map[i][j] = str.charAt(j-1) - '0';
				ans[i][j] = INF;
			}
		}
		solve();
		System.out.println(ans[N][M]);
	}
	public static void solve()
	{
		que.add(new Node(1,1,0));
		ans[1][1] = 0;
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			if(n.cost > ans[n.dx][n.dy]) continue;
			
			for(int i=0; i<4; i++)
			{
				int nx = n.dx+ dxArr[i];
				int ny = n.dy+ dyArr[i];
				if(!isRange(nx, ny)) continue;
				if(ans[nx][ny] == INF) // 방문한 적이 없다면 
				{
					if(map[nx][ny] == 1) ans[nx][ny] = 1 + ans[n.dx][n.dy];
					else ans[nx][ny] = ans[n.dx][n.dy];
					que.add(new Node(nx, ny, ans[nx][ny]));
				}
				else if(ans[nx][ny] != INF)
				{
					if(map[nx][ny] == 1 && ans[nx][ny] > 1 + ans[n.dx][n.dy]) 
					{
						ans[nx][ny] = 1 + ans[n.dx][n.dy];
						que.add(new Node(nx, ny, ans[nx][ny]));
					}
					else if(map[nx][ny] == 0 && ans[nx][ny] > ans[n.dx][n.dy]) 
					{
						ans[nx][ny] = ans[n.dx][n.dy];
						que.add(new Node(nx, ny, ans[nx][ny]));
					}
				}
			}
			
		}
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx>=1 && dy>=1 && dx<= N && dy <= M;
	}
	static class mySort implements Comparator<Node> {
		@Override
		public int compare(Node a, Node b) {
			// TODO Auto-generated method stub
			if(a.cost < b.cost) return -1;
			else if(a.cost > b.cost) return 1;
			else return 0;
		}
	}
	static class Node {
		int dx, dy, cost;
		Node(int a, int b, int c) {
			dx=a; dy=b; cost=c;
		}
	}
}
