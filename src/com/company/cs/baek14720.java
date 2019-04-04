package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 우유 축제 
 */
public class baek14720 {

	static int N;
	static int[] data = new int[1005];
	static int[][] dp = new int[1005][3];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		dp[0][0]= -1; dp[0][1] = -1; dp[0][2]= 0;
		for(int i=1; i<= N; i++)
		{
			data[i] = Integer.parseInt(st.nextToken());
			
			dp[i][0] = data[i] == 0 && dp[i-1][2] != -1 ? dp[i-1][2] + 1 : dp[i-1][0];
			dp[i][1] = data[i] == 1 && dp[i-1][0] != -1 ? dp[i-1][0] + 1 : dp[i-1][1];
			dp[i][2] = data[i] == 2 && dp[i-1][1] != -1 ? dp[i-1][1] + 1 : dp[i-1][2];
		}
		int result = 0;
		for(int i=0; i < 3; i++)
		{
			result = max(result, dp[N][i]);
		}
		System.out.println(result);
	}
	public static int max(int a, int b) { return a > b ? a : b; }
}
