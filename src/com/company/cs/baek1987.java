package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 알파벳 
 */
public class baek1987 {

	static int N, M, result;
	static int[][] data = new int[25][25];
	static int[][] visit = new int[25][25];
	static int[] dxArr = {0, 0, -1, 1}, dyArr = {1, -1, 0 , 0};
	static int[] chk = new int[30];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = 0;
		for(int i=1; i<= N; i++)
		{
			String str = br.readLine();
			for(int j=1; j<= M; j++)
			{
				data[i][j] = str.charAt(j-1) - 'A';
			}
		}
		dfs(1,1,0);
		
		System.out.println(result);
	}
	public static void dfs(int dx, int dy, int depth)
	{
		int cur = data[dx][dy];
		
		if(isPromising(dx,dy, cur))
		{
			result = max(result, depth+1);
			chk[cur] = 1;
			visit[dx][dy] = 1;
			
			for(int i=0; i< 4; i++)
			{
				int rx = dx + dxArr[i];
				int ry = dy + dyArr[i];
				if(!isRange(rx, ry) || visit[rx][ry] == 1) continue;
				dfs(rx,ry, depth+1);
			}
			
			visit[dx][dy] = 0;
			chk[cur] = 0;
		}
		
	}
	public static boolean isPromising(int dx, int dy, int num)
	{
		if(visit[dx][dy] == 1 || chk[num] == 1) return false;
		else return true;
	}
	public static boolean isRange(int dx, int dy)
	{
		return dx>=1 && dy>=1 && dx<=N && dy<= M;
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
}
