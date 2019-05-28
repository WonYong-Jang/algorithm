package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 구간 나누기 
 */
public class baek2228 {

	static final int INF = -987654321;
	static int N, M;
	static int[] data = new int[105];
	static int[] sum = new int[105];
	static int[][] dp = new int[105][105];
	static int[][] check = new int[105][105];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=0; i<= N; i++)
		{
			for(int j=0; j<= M; j++)
			{
				dp[i][j] = INF;
				check[i][j] = -1;
			}
		}
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			data[i] = Integer.parseInt(st.nextToken());
			sum[i] = (sum[i-1]+ data[i]);
		}
		System.out.println(solve(1,0));
	}
	public static int solve(int cur, int cnt)
	{
		if(cnt == M) return 0;
		else if(cur > N) return INF;
		else if(check[cur][cnt] != -1) return dp[cur][cnt];
		else
		{
			int ret = INF;
			check[cur][cnt] = 0;
			ret = max(ret, solve(cur+1, cnt));
			for(int i=0; cur+i <= N; i++)
			{
				ret = max(ret, solve(cur+2+i, cnt+1) + sum[cur+i] - sum[cur-1]);
			}
			return dp[cur][cnt] = ret;
		}
	}
	public static int max(int a, int b) { return a > b ? a : b; }
}



















