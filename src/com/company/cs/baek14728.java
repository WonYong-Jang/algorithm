package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 벼락치기 
 */
public class baek14728 {

	static int N, T;
	static int[] time = new int[1005];
	static int[] score = new int[1005];
	static int[][] dp = new int[105][10005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		int dx = 0, dy =0;
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			time[i] = dx;
			score[i] = dy;
		}
		
		for(int i=1; i<= N; i++)
		{
			dp[i][time[i]] = score[i];
			for(int j=1; j<= T; j++)
			{
				if(dp[i-1][j] > 0 && j + time[i] <= T)
				{
					dp[i][j+time[i]] = max(dp[i][j+time[i]], dp[i-1][j] + score[i]);
				}
				dp[i][j] = max(dp[i][j], dp[i-1][j]);
			}
		}
		
		int result = 0;
		for(int i=1; i<= T; i++)
		{
			result = max(result, dp[N][i]);
		}
		System.out.println(result);
	}
	public static int max(int a, int b) { return a > b ? a : b; }
}









