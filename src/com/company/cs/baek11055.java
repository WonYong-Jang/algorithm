package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 가장 큰 증가 부분 수열 
 */
public class baek11055 {

	static int N;
	static int[] data = new int[1005];
	static int[] dp = new int[1005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			int num = Integer.parseInt(st.nextToken());
			data[i] = num;
			dp[i] = num;
		}
		
		int result = data[1];
		for(int i = 2; i <= N; i++)
		{
			
			for(int j = 1; j < i; j++)
			{
				if(data[i] > data[j] && dp[i] < dp[j] + data[i])
				{
					dp[i] = dp[j] + data[i];
				}
			}
			result = max(result, dp[i]);
		}
		
		System.out.println(result);
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
}
