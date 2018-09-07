package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 나이트로 이동 
 */
public class baek7562 {

	static int N, sdx, sdy, edx, edy;
	static int[][] map = new int[305][305];
	static int[] dxArr = {-1, 0, 1, 0, 1, 1, -1, -1}, dyArr = {0, 1, 0, -1, 1, -1, -1, 1}; // 북 동 남 서 
	static int[] night = {129, 65, 130, 18, 20, 36, 72, 40}; // 나이트 이동 방향 
	static Queue<Node> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			for(int i=0; i< N; i++)
			{
				for(int j=0; j< N; j++)
				{
					map[i][j] = -1; // -1 로 초기화 
				}
			}
			st = new StringTokenizer(br.readLine());
			sdx = Integer.parseInt(st.nextToken());
			sdy = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			edx = Integer.parseInt(st.nextToken());
			edy = Integer.parseInt(st.nextToken());
			
			solve();
		}
	}
	public static void solve()
	{
		que.clear();
		map[sdx][sdy] = 0;
		que.add(new Node(sdx,sdy));
		while(!que.isEmpty())
		{
			Node n = que.poll();
			if(n.dx == edx && n.dy == edy) { // 도착 했을 경우 
				System.out.println(map[n.dx][n.dy]);
				return;
			}
			
			for(int i=0; i < 8; i++)
			{
				int nx = n.dx, ny = n.dy;
				for(int j = 0; j < 8; j++)
				{
					if( (night[i]  & (1 << j)) > 0 ) // 정해 놓은 나이트 이동 경로 이동 
					{
						nx += dxArr[j];
						ny += dyArr[j];
					}
				}
				if(!isRange(nx, ny)) continue;
				if(map[nx][ny] == -1 || map[nx][ny] > map[n.dx][n.dy] + 1) // 처음 방문하거나 더빠른 경로 갱신 
				{
					map[nx][ny] = map[n.dx][n.dy] + 1;
					que.add(new Node(nx, ny));
				}
			}
		}
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >= 0 && dy >= 0 && dx < N && dy < N;
	}
	static class Node {
		int dx, dy;
		Node(int x, int y) { 
			dx = x ; dy = y;
		}
	}
}
