package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 목장 건설하기 ( DP) 
 */
public class baek14925 {

	static int[][] data = new int[1001][1001];
	static int[][] d = new int[1001][1001];
	static int N, M, ans=0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<= M; j++)
			{
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= M; j++)
			{
				if(data[i][j] == 1 || data[i][j] == 2) continue;
				if(!isRange(i-1,j-1) || !isRange(i-1,j) || !isRange(i,j-1) ) d[i][j] = 1; // 그냥 1 x 1 정사각형
				else
				{
					d[i][j] = 1 + min(d[i][j-1] , min(d[i-1][j-1], d[i-1][j]));
				}
				ans = max(ans, d[i][j]);
			}
		}
		System.out.println(ans);
	}
	public static boolean isRange(int a, int b)
	{
		return a >= 1 && a <= N && b >=1 && b <= M;
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
	public static int min(int a, int b)
	{
		return a > b ? b: a;
	}
}





