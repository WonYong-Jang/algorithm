package com.company.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 테트리미노 
 */
public class baek14500_2 {

	static int N, M, ans;
	static int[][] map = new int[505][505];
	static int[][] visit = new int[505][505];
	static int[] dxArr = {0, 0, 1, -1}, dyArr = {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = 0;
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<= M; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= M; j++)
			{
				
				visit[i][j] = 1;
				solve(i, j, 1, map[i][j]);
				visit[i][j] = 0;
				
				exception(i, j);
			}
		}
		
		
		System.out.println(ans);
	}
	public static void solve(int dx, int dy, int depth, int sum)
	{
		if(depth == 4)
		{
			ans = max(ans, sum);
			return;
		}
		
		for(int i=0; i<4; i++)
		{
			int nx = dx + dxArr[i];
			int ny = dy + dyArr[i];
			if(!isRange(nx, ny) || visit[nx][ny] == 1) continue;
			visit[nx][ny] = 1;
			solve(nx, ny, depth+1, map[nx][ny] + sum);
			visit[nx][ny] = 0;
		}
	}
	public static void exception(int dx, int dy)
	{
		
		if(isRange(dx+1,dy) && isRange(dx+2,dy) && isRange(dx+1,dy+1) ) {
			ans = max(ans, map[dx][dy]+map[dx+1][dy]+map[dx+2][dy]+map[dx+1][dy+1]);
		}
		if(isRange(dx,dy+1) && isRange(dx,dy+2) && isRange(dx-1,dy+1) ) {
			ans = max(ans, map[dx][dy]+map[dx][dy+1]+map[dx][dy+2]+map[dx-1][dy+1]);
		}
		if(isRange(dx-1,dy) && isRange(dx-2,dy) && isRange(dx-1,dy-1) ) {
			ans = max(ans, map[dx][dy]+map[dx-1][dy]+map[dx-2][dy]+map[dx-1][dy-1]);
		}
		if(isRange(dx,dy-1) && isRange(dx,dy-2) && isRange(dx+1,dy-1) ) {
			ans = max(ans, map[dx][dy]+map[dx][dy-1]+map[dx][dy-2]+map[dx+1][dy-1]);
		}
		
		
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx>=1 && dy>=1 && dx<= N && dy <= M;
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
}
