package com.company.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 
 * RGB 거리 
 */
public class baek1149 {

	static int N, result;
	static int[][] dp = new int[1005][4];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		result = Integer.MAX_VALUE;
		
		N = Integer.parseInt(st.nextToken());
		int num =0;
		for(int i=1; i<= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			
			for(int j=1; j<= 3; j++)
			{
				num = Integer.parseInt(st.nextToken());
				if(j == 1) dp[i][j] = min(dp[i-1][2], dp[i-1][3]) + num;
				else if(j==2) dp[i][j] = min(dp[i-1][1], dp[i-1][3]) + num;
				else if(j==3) dp[i][j] = min(dp[i-1][1], dp[i-1][2]) + num;
				
				if(i == N) result = min(result, dp[i][j]);
			}
		}
		System.out.println(result);
	}
	public static int min(int a, int b) { return a > b? b : a; }
}
