package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 앱 
 */
public class baek7579 {

	static int N, M;
	static int[] memory = new int[105];
	static int[] cost = new int[105];
	static int[][] dp = new int[105][10005]; // dp[N][cost] = memory 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=5; i++)
		{
			memory[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=5; i++)
		{
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<= N; i++)
		{
			dp[i][cost[i]] = memory[i];
			for(int j=0; j<= 10000; j++)
			{
				if(dp[i-1][j] > 0) 
				{
					dp[i][cost[i] + j] = max(dp[i][cost[i]+j], dp[i-1][j] + memory[i] );
				}
				
				dp[i][j] = max(dp[i][j], dp[i-1][j]);
			}
		}
		int ans = 0;
		for(int i=0; i<= 10000; i++)
		{
			if(dp[N][i] >= M) {
				ans = i;
				break;
			}
		}
		System.out.println(ans);
	}
	public static int max(int a, int b) { return a > b ? a : b; }
}
