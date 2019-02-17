package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 합분해 
 */
public class baek2225 {

	static int N, K;
	static long[][] dp = new long[205][205];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i <= N; i++) dp[1][i] = 1;
		for(int i = 0; i <= K; i++) dp[i][0] = 1;
		
		for(int i=2; i<= K; i++)
		{
			for(int j=1; j<= N; j++)
			{
				dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000000;
			}
		}
		System.out.println(dp[K][N]);
	}

}
