package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * 피보나치 수 
 */
public class baek2747 {

	static int N;
	static BigInteger[] dp = new BigInteger[10005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		dp[0] = BigInteger.valueOf(0); dp[1] = BigInteger.valueOf(1);
		
		for(int i=2; i<= N; i++)
		{
			dp[i] = dp[i-2].add(dp[i-1]);
		}
		System.out.println(dp[N]);
	}
}




