package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek13398 {

	static int N;
	static int[] data = new int[100005];
	static int[][] dp = new int[2][100005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			data[i] = Integer.parseInt(st.nextToken());
		}
		int result = data[1];
		dp[0][1] = data[1];
		dp[1][1] = 0;
		for(int i=2; i<= N; i++)
		{
			dp[0][i] = max(data[i], data[i] + dp[0][i-1]);
			dp[1][i] = max(dp[1][i-1] + data[i], dp[0][i-2]+ data[i]);
			result = max(result, max(dp[0][i], dp[1][i]));
		}
		
		System.out.println(result);
	}
	public static int max(int a, int b) { return a > b ? a : b; }
}
