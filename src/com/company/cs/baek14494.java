package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek14494 {

	static final int mod = 1000000007;
	static int N, M;
	static long[][] dp = new long[1005][1005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dp[0][0] = 1;
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= M; j++)
			{
				dp[i][j] = (dp[i-1][j]+dp[i-1][j-1]+dp[i][j-1]) % mod;
			}
		}
		System.out.println(dp[N][M]);
	}

}
