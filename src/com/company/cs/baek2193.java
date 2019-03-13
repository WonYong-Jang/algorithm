package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 이친수 
 */
public class baek2193 {

	static int N;
	static long[] dp = new long[105];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		dp[1] = 1; dp[2] = 1;
		for(int i=3; i<= N; i++)
		{
			dp[i] = dp[i-1] + dp[i-2];
		}
		System.out.println(dp[N]);
	}

}
