package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 악수 
 */
public class baek8394 {

	static int N;
	static long[] dp = new long[10000005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3; i<= N; i++)
		{
			dp[i] = (dp[i-1] + dp[i-2]) % 10;
		}
		System.out.println(dp[N] % 10);
	}

}
