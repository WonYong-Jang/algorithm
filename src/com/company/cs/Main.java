package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] coin = new int[105];
	static int[][] dp = new int[105][10005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			coin[i] = Integer.parseInt(st.nextToken());
			dp[i][0] = 1;
		}
		
		int num = 0;
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= M; j++)
			{
				if(j-coin[i] < 0) num = 0;
				else num = dp[i][j-coin[i]];
				
				dp[i][j] = dp[i-1][j] + num;
			}
		}
		System.out.println(dp[N][M]);
	}

}
