package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 설탕 배달 
 */
public class baek2839 {

	static int N; 
	static int[] dp = new int[5005];
	static int[] coin = new int[3];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		coin[1] =3; coin[2] = 5;
		for(int i=1; i<= N; i++) dp[i] = -1;
		
		int minCnt = 0;
		boolean flag = false;
		for(int i=1; i<= N; i++)
		{
			minCnt = 10000;
			flag = false;
			for(int j=1; j<=2; j++)
			{
				if(i-coin[j]  < 0) continue;
				if( dp[i-coin[j]] + 1 < minCnt && dp[i-coin[j]] != -1)
				{
					minCnt = dp[i-coin[j]] + 1;
					flag = true;
				}
			}
			if(flag)
			{
				dp[i] = minCnt;
			}
		}
		System.out.println(dp[N]);
		
		
	}
}
