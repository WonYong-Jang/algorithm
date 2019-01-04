package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 키 순서  
 */
public class baek2458 {

	static final int INF = 987654321;
	static int N, M, result, cnt; 
	static int[][] dp = new int[505][505];
	static int[] isConnected = new int[505];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = 0;
		
		for(int i=1; i<= N; i++)
			for(int j=1; j<= N; j++) dp[i][j] = INF;
		
		int dx = 0, dy = 0;
		for(int i=1; i<= M; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			dp[dx][dy] = 1;
		}
		
		for(int k=1; k<= N; k++)
		{
			for(int i=1; i <= N; i++)
			{
				for(int j=1; j<= N; j++)
				{
					if(dp[i][j] > dp[i][k] + dp[k][j])
					{
						dp[i][j] = dp[i][k] + dp[k][j];
					}
				}
			}
		}
		
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= N; j++)
			{
				if(dp[i][j] != INF)
				{
					isConnected[i]++; // 들어가는 방향 
					isConnected[j]++; // 나가는 방향 
					
					if(isConnected[i] == N-1) result++;
					if(isConnected[j] == N-1) result++;
				}
			}
		}
		
		System.out.println(result);
	}
}





