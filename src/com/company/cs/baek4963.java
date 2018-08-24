package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 섬의 갯수 
 */
public class baek4963 {

	static int[][] map = new int[55][55];
	static int[][] visit = new int[55][55];
	static int N, M, ans;
	static Queue<Node> que = new LinkedList<>();
	static int[] dxArr = {0, 0, 1, -1, 1, -1, 1, -1}, dyArr = {1, -1, 0, 0, 1, -1, -1, 1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while(true)
		{
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			ans = 0;
			if( N == 0 && M ==0 ) break;
			
			for(int i=1; i<= N; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<= M; j++)
				{
					visit[i][j] = 0; // 초기화 
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=1; i<= N; i++)
			{
				for(int j=1; j<= M; j++)
				{
					if(visit[i][j] == 1 || map[i][j] ==0) continue;
					solve(i,j);
					ans++;
				}
			}
			System.out.println(ans);
		}
	}
	public static void solve(int dx, int dy)
	{
		visit[dx][dy] = 1;
		que.add(new Node(dx, dy));
		while(!que.isEmpty())
		{
			Node n = que.poll();
			
			for(int i=0; i<8; i++)
			{
				int nx = n.dx + dxArr[i];
				int ny = n.dy + dyArr[i];
				if(!isRange(nx, ny) || visit[nx][ny] == 1 || map[nx][ny] ==0) continue;
				visit[nx][ny] = 1;
				que.add(new Node(nx,ny));
			}
		}
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >= 1 && dy >= 1 && dx <= N && dy <= M;
	}
	static class Node {
		int dx, dy;
		Node(int x, int y) {
			dx =x; dy = y;
		}
	}
}









