package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 자두나무 
 */
public class baek2240 {

	static int T, W;
	static int[] data = new int[1005];
	static int[][][] dp = new int[1005][35][3];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		for(int i=1; i<= T; i++)
		{
			st = new StringTokenizer(br.readLine());
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<= T; i++)
		{
			for(int j=1; j<= W+1; j++)
			{
				if(data[i] == 1)
				{
					dp[i][j][1] = max(dp[i-1][j][1], dp[i-1][j-1][2]) + 1;
					dp[i][j][2] = max(dp[i-1][j][2], dp[i-1][j-1][1]);
				}
				else 
				{
					if(i==1 && j==1) continue;
					dp[i][j][1] = max(dp[i-1][j][1], dp[i-1][j-1][2]);
					dp[i][j][2] = max(dp[i-1][j][2], dp[i-1][j-1][1]) + 1;
				}
			}
		}
		
		int ans = 0;
		for(int i=1; i<= W+1; i++)
		{
			ans = max(ans, max( dp[T][i][1], dp[T][i][2]));
			
		}
		System.out.println(ans);
	}
	public static int max(int a, int b) { return a > b ? a : b ;}
}
