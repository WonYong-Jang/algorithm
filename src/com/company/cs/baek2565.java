package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 전깃줄 
 */
public class baek2565 {

	static int N;
	static int[] data = new int[505];
	static int[] dp = new int[505];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		int dx = 0, dy =0;
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			data[dx] = dy;
		}
		
		int result = 0;
		for(int i=1; i<= 500; i++)
		{
			for(int j=0; j<i; j++)
			{
				if(data[i] > data[j] && dp[i] < dp[j] + 1)
				{
					dp[i] = dp[j] + 1;
				}
			}
			result = max(result, dp[i]);
		}
		
		System.out.println(N-result);
	}
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
}
