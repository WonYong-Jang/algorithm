package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 동전 
 */
public class baek9084 {

	static int N, K;
	static int[] coin = new int[21];
	static int[] dp = new int[10001];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<= N; i++)
			{
				coin[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			
			for(int i=1; i<= K; i++) dp[i] = 0;
			dp[0] = 1;
			int num =0;
			for(int i=1; i<= N; i++)
			{
				for(int j=1; j<= K; j++)
				{
					if(j- coin[i] < 0) num =0;
					else num = dp[j-coin[i]];
					dp[j] += num;
				}
			}
			System.out.println(dp[K]);
		}
	}
}
