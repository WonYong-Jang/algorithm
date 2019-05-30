package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] dp = new int[10005];
	static int[] data = new int[10005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1] = data[1];
		dp[2] = data[2] + data[1];
		for(int i=3; i<= N; i++)
		{
			dp[i] = max(dp[i], data[i]+data[i-1]+dp[i-3]);
			dp[i] = max(dp[i], data[i] + dp[i-2]);
			dp[i] = max(dp[i], dp[i-1]);
		}
		System.out.println(dp[N]);
	}
	public static int max(int a, int b) { return a > b ? a : b; }
}
