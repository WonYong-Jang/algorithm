package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 평범한 배낭 
 */
public class baek12865 {

	static int N, K;
	static int[] weight = new int[105];
	static int[] value = new int[105];
	static int[][] dp = new int[105][100005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int dx =0, dy=0;
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			weight[i]= dx;
			value[i] = dy;
		}
		int num = 0;
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= K; j++)
			{
				if(j-weight[i] < 0) num = dp[i-1][j];
				else num = max(dp[i-1][j] , value[i] + dp[i-1][j-weight[i]]);
				dp[i][j] = num;
			}
		}
		
		
		System.out.println(dp[N][K]);
	}
	public static int max(int a, int b) { return a > b? a: b; }
}

/**
4 7
6 13
4 8
1 0
3 6
 */
