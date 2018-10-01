package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 포도주 시식 
 */
public class baek2156 {

	static int N;
	static int[] wine = new int[10005];
	static int[] dp = new int[10005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			wine[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1] = wine[1];
		dp[2] = wine[2] + wine[1];
		for(int i=3; i <= N; i++)
		{
			dp[i] = max( max( dp[i-1] , wine[i] + wine[i-1] + dp[i-3]) , wine[i] + dp[i-2]);
		}
		// 현재 잔을 안마신 경우              dp[i] = dp[i-1]
		// 현재 잔을 마시고 이전잔을 마신경우    dp[i] = wine[i] + wine[i-1] + dp[i-3]
		// 현재 잔을 마시고 이전잔을 안마신 경우  dp[i] = wine[i] + dp[i-2]
		
		System.out.println(dp[N]);
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
}
