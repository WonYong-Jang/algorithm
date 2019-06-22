package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 환상의 듀엣 
 */
public class baek11570 {

	//static final int INF = 2000000005;
	static final int INF = 100;
	static int N;
	static int[] data = new int[2005];
	static int[][] dp = new int[2005][2005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken())+1;
		st = new StringTokenizer(br.readLine());
		
		for(int i=2; i<= N; i++)
		{
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<= N; i++)
		{
			for(int j=0; j<= N; j++)
			{
				dp[i][j] = INF;
			}
		}
		dp[1][2] = 0;
		for(int i = 1; i < N; i++)
		{
			for(int j = i+1; j < N; j++)
			{
				int k = j + 1;
				if(i == 1 && dp[j][k] > dp[i][j])
				{
					dp[j][k] = dp[i][j];
				}
				else if(i > 1 && dp[j][k] > dp[i][j] + dis(i,k))
				{
					dp[j][k] = dp[i][j] + dis(i,k);
				}
				
				if(dp[i][k] > dp[i][j] + dis(j,k))
				{
					dp[i][k] = dp[i][j] + dis(j,k);
				}
			}
		}
		
		int result = INF;
		for(int i=1; i< N; i++)
		{
			result = min(result, dp[i][N]);
		}
		System.out.println(result);
	}
	public static int min(int a, int b) { return a > b ? b : a; }
	public static int dis(int a, int b)
	{
		return data[a] > data[b] ? data[a] - data[b] : data[b] - data[a];
	}
}
