package com.company.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 가장 긴 증가하는 부분 수열 
 */
public class baek11053 {

	static int N, result;
	static int[] data = new int[1005];
	static int[] dp = new int[1005]; // data[i] 가 가르키는 값에 대한 가장 긴 증가 수열 값 저장 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		result = 1;
		N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<= N; i++)
		{
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<= N; i++)
		{
			for(int j=0; j < i; j++)
			{
				if(data[i] > data[j] && dp[i] < dp[j] + 1)
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



