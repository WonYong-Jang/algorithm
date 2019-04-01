package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek1904 {

	static final int mod = 15746;
	static int N;
	static long[] dp = new long[1000005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		dp[1] = 1; dp[2] = 2; dp[3] = 3;
		for(int i=4; i<= N; i++)
		{
			dp[i] = (dp[i-1] + dp[i-2] ) % mod;
		}
		System.out.println(dp[N]);
	}

}
