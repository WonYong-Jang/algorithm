package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * ATM 
 */
public class baek11399 {

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
		Arrays.sort(data, 1, N+1);
		int sum = 0;
		for(int i=1; i<= N; i++)
		{
			dp[i] = dp[i-1] + data[i];
			sum += dp[i];
		}
		
		System.out.println(sum);
	}

}
