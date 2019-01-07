package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 안녕 
 */
public class baek1535 {

	static int N, result;
	static int[][] data = new int[3][25];
	static int[] visit = new int[25];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		result = 0;
		for(int i=1; i<=2; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<= N; j++)
			{
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<= N; i++)
		{
			if(100 - data[1][i] <= 0) continue;
			
			visit[i] = 1;
			dfs(i, 100 - data[1][i], data[2][i]);
			visit[i] = 0;
		}
		
		System.out.println(result);
	}
	public static void dfs(int index, int remain, int happy)
	{
		result = max(result, happy);
		
		for(int i = index+1; i<= N; i++)
		{
			if(visit[i] == 1) continue;
			if(remain - data[1][i] > 0)
			{
				visit[i] = 1;
				dfs(i, remain - data[1][i], happy + data[2][i]);
				visit[i] = 0;
			}
		}
	}
	public static int max(int a, int b) { return a > b ? a : b; }
}






