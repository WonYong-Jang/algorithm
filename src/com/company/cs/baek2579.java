package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 계단 오르기 
 */
public class baek2579 {

	static int N;
	static int[] dp = new int[305];
	static int[] data = new int[305];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			data[i] = Integer.parseInt(st.nextToken());
		}
		dp[1] = data[1];
		dp[2] = data[1] + data[2];
		for(int i=3; i<= N; i++)
		{
			dp[i] = max(dp[i-2] + data[i] , dp[i-3] + data[i-1] + data[i]);
		}
		System.out.println(dp[N]);
	}
	public static int max(int a, int b) { return a > b ? a : b;}
}
