package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 서울에서 경산까지 
 */
public class baek14863 {

	static int N, K;
	static int[][] ride = new int[105][2];
	static int[][] bicycle = new int[105][2];
	static int[][] dp = new int[105][100005];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int time1 =0, time2=0, cost1=0, cost2=0;
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			time1 = Integer.parseInt(st.nextToken());
			cost1 = Integer.parseInt(st.nextToken());
			time2 = Integer.parseInt(st.nextToken());
			cost2 = Integer.parseInt(st.nextToken());
			ride[i][0] = time1;
			ride[i][1] = cost1;
			bicycle[i][0] = time2;
			bicycle[i][1] = cost2;
		}
		for(int i=0; i<= N; i++)
			for(int j=0; j<= K; j++)
				dp[i][j] = -1;
		
		int result = solve(0, 0);
		System.out.println(result);
	}
	public static int solve(int cur, int time)
	{
		if(time > K || cur > N) return -2;
		else if(cur == N) return 0;
		else if(dp[cur][time] != -1) return dp[cur][time];
		else
		{
			int num = -2, result =0;
			result = solve(cur+1, time+ride[cur+1][0]);
			if(result != -2) num = max(num, result+ride[cur+1][1]);
			
			result = solve(cur+1, time+bicycle[cur+1][0]);
			if(result != -2) num = max(num, result+bicycle[cur+1][1]);
			
			return dp[cur][time] = num;
		}
	}
	public static int max(int a, int b) { return a > b ? a : b; }
}











