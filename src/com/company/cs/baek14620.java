package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 꽃길 
 */
public class baek14620 {

	static int ans = 200 * 15 * 15;
	static int[][] map = new int[11][11];
	static int[][] visited = new int[11][11];
	static int N;
	static int[] dxArr = {1, -1, 0, 0}, dyArr = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<= N; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= N; j++)
			{
				if(!isRange(i,j)) continue;
				
				int sum = map[i-1][j] + map[i][j-1] + map[i+1][j] +map[i][j+1] + map[i][j]; // 5 평 확인  
				visited[i][j] = 1;
				visited[i-1][j] = 1;
				visited[i][j-1] = 1;
				visited[i+1][j] = 1;
				visited[i][j+1] = 1;
				solve(1, sum, i, j );
				visited[i][j] = 0;
				visited[i-1][j] = 0;
				visited[i][j-1] = 0;
				visited[i+1][j] = 0;
				visited[i][j+1] = 0;
			}
		}
		System.out.println(ans);
	}
	public static void solve(int cnt, int sum, int dx, int dy)
	{
		if(cnt == 3) {
			ans = min(ans, sum);
			
			return;
		}
		
		if(ans < sum) return; // 최소 비용 찾는 거니까 
		
		for(int i=dx; i<= N; i++)
		{
			for(int j=1; j<= N; j++)
			{
				if(!isRange(i,j)) continue;
				int temp = map[i-1][j] + map[i][j-1] + map[i+1][j] +map[i][j+1] + map[i][j]; // 5 평 확인  
				visited[i][j] = 1;
				visited[i-1][j] = 1;
				visited[i][j-1] = 1;
				visited[i+1][j] = 1;
				visited[i][j+1] = 1;
				solve(cnt+1, sum + temp, i, j );
				visited[i][j] = 0;
				visited[i-1][j] = 0;
				visited[i][j-1] = 0;
				visited[i+1][j] = 0;
				visited[i][j+1] = 0;
			}
		}
	}
	public static boolean isRange(int dx, int dy)
	{
		if(visited[dx][dy] == 1) return false;
		for(int i=0; i<4; i++)
		{
			int ndx = dx + dxArr[i];
			int ndy = dy + dyArr[i];
			if(ndx < 1 || ndy < 1 || ndx > N || ndy > N || visited[ndx][ndy] == 1 ) return false;
		}
		return true;
	}
	public static int min(int a, int b)
	{
		return a>b? b:a;
	}
}






