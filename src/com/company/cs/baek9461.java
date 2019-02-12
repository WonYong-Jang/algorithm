package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 파도반 수열 
 */
public class baek9461 {

	static int N;
	static long[] dp = new long[105];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		
		dp[1] = 1; dp[2] = 1; dp[3] = 1;
		for(int i=4; i<= 100; i++)
		{
			dp[i] = dp[i-3] + dp[i-2];
		}
		
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			System.out.println(dp[N]);
		}
	}

}
