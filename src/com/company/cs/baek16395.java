package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek16395 {

	static int N, K;
	static int[][] dp = new int[35][35];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<= N; i++)
		{
			dp[i][i] = 1;
			dp[i][1] = 1;
		}
		
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<=N; j++)
			{
				if(dp[i][j] == 0)
				{
					dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
				}
			}
		}
		
		System.out.println(dp[N][K]);
	}
}




