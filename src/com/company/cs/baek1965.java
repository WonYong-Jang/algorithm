package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 상자 넣기 O(N^2)
 */
public class baek1965 {

	static int N;
	static int[] dp = new int[1005];
	static int[] data = new int[1005];
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
		int result = 0;
		for(int i=1; i<= N; i++)
		{
			for(int j=0; j < i; j++)
			{
				if(data[j] < data[i] && dp[i] < dp[j] + 1  )
				{
					dp[i] = dp[j] + 1;
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
