package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek2591 {
	
	static int N;
	static int[] data = new int[50];
	static int[] dp = new int[50];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		N = str.length();
		for(int i=1; i<= N; i++)
		{
			data[i] = str.charAt(i-1) - '0';
		}
		dp[0] = 1;
		
		int target = 0, sum = 0;
		for(int i=1; i<= N; i++)
		{
			target = data[i];
			if(target > 0) 
			{
				dp[i] += dp[i-1];
			}
			sum = data[i-1] * 10 + target;
			if(sum >=1 && sum <= 34 && data[i-1] != 0)
			{
				dp[i] += dp[i-2];
			}
		}
		System.out.println(dp[N]);
	}
	
}
