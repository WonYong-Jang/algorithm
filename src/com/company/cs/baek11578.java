package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 아이템 먹기 
 */
public class baek11578 {

	static final int INF = 1500;
	static int N, M, whole;
	static int[] student = new int[15];
	static int[][] dp = new int[15][1050];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int cnt = 0, sum = 0, num =0;
		
		whole = (1 << N) -1;
		for(int i=0; i<= M; i++)
		{
			for(int j=1; j<= whole; j++)
			{
				dp[i][j] = INF;
			}
		}
		
		for(int i=1; i<= M; i++)
		{
			st = new StringTokenizer(br.readLine());
			cnt = Integer.parseInt(st.nextToken());
			sum = 0; num =0;
			for(int j=1; j<= cnt; j++)
			{
				num = Integer.parseInt(st.nextToken());
				sum += (1 << (num-1));
			}
			student[i] = sum;
		}
		
		int target = 0;
		for(int i=1; i<= M; i++)
		{
			dp[i][student[i]] = 1;
			for(int j=1; j<= whole; j++)
			{
				if(dp[i-1][j] != INF )
				{
					target = j | student[i];
					dp[i][target] = min(dp[i][target], dp[i-1][j]+1);
				}
				dp[i][j] = min(dp[i][j], dp[i-1][j]);
			}
		}
		int result = INF;
		for(int i=1; i<= M; i++)
		{
			result = min(result, dp[i][whole]);
		}
		if(result == INF) System.out.println(-1);
		else System.out.println(result);
	}
	public static int min(int a, int b) { return a > b ? b : a; }
}
