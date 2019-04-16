package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 팰린드롬 만들기 
 */
public class baek1695 {

	static int N;
	static int[] data = new int[5005];
	static int[][] dp = new int[5005][5005];
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
		System.out.println(solve(1, N));
	}
	public static int solve(int s, int e)
	{
		int result = 0;
		//System.out.println(s+ " "+ e);
		if( s >= e) return 0;
		else if(dp[s][e] > 0) return dp[s][e];
		else if(data[s] == data[e])
		{
			result = solve(s+1, e-1);
			return dp[s][e] = result;
		}
		else
		{
			int left = solve(s+1, e);
			int right = solve(s, e-1);
			result = min(left, right) + 1;
			return dp[s][e] = result;
		}
	}
	public static int min(int a, int b) { return a > b ? b : a; }
}
