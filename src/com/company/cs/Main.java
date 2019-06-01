package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static final int mod = 9901;
	static int N;
	static long[][] dp = new long[100005][3];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		dp[0][0] = 0; dp[0][1] = 0; dp[0][2] = 1;
		for(int i=1; i<= N; i++)
		{
			dp[i][0] = (dp[i-1][1] + dp[i-1][2]) % mod;
			dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % mod;
			dp[i][2] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % mod;
		}
		long result = (dp[N][0] + dp[N][1] + dp[N][2]) % mod;
		System.out.println(result);
	}
	public static int max(int a, int b) { return a > b ? a : b ;}
}