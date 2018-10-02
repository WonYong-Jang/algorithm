package com.company.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * 조합 
 */
public class baek2407 {

	static int N, M;
	static BigInteger[][] dp = new BigInteger[105][105];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<= N; i++)
		{
			for(int j=0; j<= i; j++)
			{
				if(j == 0 || i == j) dp[i][j] = BigInteger.valueOf(1);
				else
				{
					dp[i][j] = dp[i-1][j-1].add(dp[i-1][j]);
				}
			}
		}
		
		System.out.println(dp[N][M]);
		
	}
	
}
