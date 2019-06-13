package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 현상금 사냥꾼 김정은 
 */
public class baek10272 {

	static final double INF = 2e9;
	static int N;
	static double[][] point = new double[550][2];
	static double[][] dp = new double[550][550]; 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for(int n=1; n <= testCase; n++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int dx =0, dy =0;
			for(int i=1; i<= N; i++)
			{
				st = new StringTokenizer(br.readLine());
				dx = Integer.parseInt(st.nextToken());
				dy = Integer.parseInt(st.nextToken());
				point[i][0] = dx; point[i][1] = dy;
				for(int j=1; j<= N; j++)
				{
					dp[i][j] = INF;
				}
			}
			
			dp[1][1] = 0; // 똑같은점 있음 안됨 
			dp[1][2] = dis(1,2); // i < j 처음 이동시켜 놓고 시작 
			for(int i=1; i < N; i++)
			{
				for(int j = i+1; j < N; j++) // 1 ~ N-1 까지 이동 
				{
					int k = j + 1; // k : 다음 방문할 곳 / 
					// i에서 이동할 경우 => dp[k][j] = dis(i,k) + dp[i][j]
					// j에서 이동할 경우 => dp[i][k] = dis(j,k) + dp[i][j]
					dp[j][k] = min(dp[j][k], dis(i,k) + dp[i][j]);
					dp[i][k] = min(dp[i][k], dis(j,k) + dp[i][j]);
				}
			}
			double ans = INF;
			for(int i=1; i < N; i++) // N-1 ~ 에서 N 
			{
				ans = min(ans, dp[i][N] + dis(i,N));
			}
			System.out.println(ans);
		}
	}
	public static double min(double a, double b) { return a > b ? b : a; }
	public static double dis(int a, int b)
	{
		return Math.sqrt( (point[a][0]-point[b][0])*(point[a][0]-point[b][0]) + (point[a][1]-point[b][1])*(point[a][1]-point[b][1]) );
	}
}
