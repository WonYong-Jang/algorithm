package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 내리막 길 
 */
public class baek1520 {

	static int M, N, ans;
	static int[][] map = new int[505][505];
	static int[] dxArr = {0, 0, 1, -1}, dyArr = {1, -1, 0, 0};
	static Queue<Node> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		ans =0;
		for(int i=1; i<= M; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<= N; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve();
		System.out.println(ans);
	}
	public static void solve()
	{
		que.add(new Node(1,1));
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			if(n.dx == M && n.dy == N) {
				ans++;
				continue;
			}
			
			for(int i=0; i<4; i++)
			{
				int nx = n.dx + dxArr[i];
				int ny = n.dy + dyArr[i];
				if(!isRange(nx, ny) || map[n.dx][n.dy] <= map[nx][ny]) continue;
				que.add(new Node(nx, ny));
			}
		}
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx>=1 && dy>=1 && dx<= M && dy <= N;
	}
	static class Node {
		int dx, dy;
		Node(int x, int y) {
			dx =x; dy = y;
		}
	}
}
