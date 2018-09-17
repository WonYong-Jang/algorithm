package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 내리막 길 ( dfs + dp 해결 ) / bfs 시간 초과 
 */
public class baek1520 {

	static int M, N;
	static int[][] map = new int[505][505];
	static int[][] visit = new int[505][505];
	static int[] dxArr = {0, 0, 1, -1}, dyArr = {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<= M; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<= N; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
				visit[i][j] = -1; // 0 으로 초기화 하게 됬을때 시간초과 발생
				/**
				 *    4
				 *  2 1 3    ==> 이런 경우 1인점으로 들어왔을 때 상하좌우 다 자기보다 크기때문에 그대로 0
				 *    2          하지만 0이 방문해서 0인점인데 조건에 안맞아서 그대로 0인지 알지 못하기 때문 
				 */
			}
		}
		int ans = solve(1,1);
		System.out.println(ans);
		
	}
	public static int solve(int dx, int dy)
	{
		if(visit[dx][dy] == -1) { // 한번도 방문한적이 없을 때 
			visit[dx][dy] = 1;
			
			if(dx == M && dy == N) { // 도착했을때 
				return 1;
			}
			int sum =0;
			for(int i=0; i<4; i++)
			{
				int nx = dx + dxArr[i];
				int ny = dy + dyArr[i];
				if(!isRange(nx,ny) || map[dx][dy] <= map[nx][ny]) continue;
				sum += solve(nx, ny);
			}
			return visit[dx][dy] = sum; // 갱신 해당 지점에서부터 가능한 경로의 합 
		}
		else {
			if(visit[dx][dy] == 0 ) return 0; // 방문은 했으나 갈수 없는 경우 
			else return visit[dx][dy]; // 1이상 
		}
	}
	public static void debug()
	{
		for(int i=1; i<=M; i++)
		{
			for(int j=1; j<= N; j++)
			{
				System.out.print(visit[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >= 1 && dy >= 1 && dx <= M && dy <= N;
	}
	static class Node {
		int dx, dy;
		Node(int x, int y) {
			dx = x; dy = y;
		}
	}
}
