package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1로 만들기 
 */
public class baek1463 {

	static int N;
	static int[] dp = new int[1000005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		dp[1] = 0;
		for(int i=2; i<= N; i++)
		{
			dp[i] = dp[i-1] + 1; // -1 하는 경우 
			if(i % 2 == 0) dp[i] = min(dp[i], dp[i/2] + 1);
			if(i % 3 == 0) dp[i] = min(dp[i], dp[i/3] + 1);
		}
		System.out.println(dp[N]);
	}
	public static int min(int a, int b) { return a > b ? b : a; }
}
