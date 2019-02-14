package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 연속합 
 */
public class baek1912 {

	static int N, result;
	static int[] dp = new int[100005];
	static int[] data = new int[100005];
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
		result = data[1];
		for(int i=1; i<= N; i++)
		{
			if(dp[i-1] + data[i] > data[i])
			{
				dp[i] = dp[i-1] + data[i];
				result = max(result, dp[i]);
			}
			else {
				dp[i] = data[i];
				result = max(result, dp[i]);
			}
		}
		System.out.println(result);
	}
	public static int max(int a, int b) { return a > b ? a : b; }
}
