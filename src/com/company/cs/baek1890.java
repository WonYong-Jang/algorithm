package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 점프 ( dfs + dp )
 */
public class baek1890 {

	static int N;
	static int[][] map = new int[105][105];
	static long[][] visit = new long[105][105];
	static int[] dxArr = {0, 1}, dyArr = {1, 0}; // 동 , 북 방향만 이동 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<= N; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
				visit[i][j] = -1;
			}
		}
		
		System.out.println(solve(1,1));
	}
	public static long solve(int dx, int dy)
	{
		if(dx == N && dy == N) return 1;
		else if(visit[dx][dy] != -1) return visit[dx][dy];
		else
		{
			int jump = map[dx][dy];
			visit[dx][dy] = 0;
			for(int i=0; i<2; i++)
			{
				int nx = dx + (dxArr[i]*jump);
				int ny = dy + (dyArr[i]*jump);
				if(!isRange(nx, ny)) continue;
				visit[dx][dy] += solve(nx, ny);
			}
			return visit[dx][dy];
		}
		
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx >= 1 && dy >= 1 && dx <= N && dy <= N;
	}
}
