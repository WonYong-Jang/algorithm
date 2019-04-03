package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek10164 {

	static int N, M, K, dx, dy;
	static int[][] dp = new int[20][20];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int index = 0;
		dx = 0; dy = 0;
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= M; j++)
			{
				index++;
				if(index == K)
				{
					dx = i; dy = j;
				}
			}
		}
		dp[0][1] = 1;
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= M; j++)
			{
				if( (dx < i && dy > j) || (dx > i && dy < j) )
				{
					dp[i][j] = 0;
				}
				else dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		System.out.println(dp[N][M]);
	}

}
