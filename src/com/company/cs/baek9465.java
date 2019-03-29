package com.company.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 스티커 
 */
public class baek9465 {

	static int N;
	static int[][] dp = new int[2][100005];
	static int[][] data = new int[2][100005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for(int k=1; k<= testCase; k++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<2; i++) 
			{
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<= N; j++)
				{
					dp[i][j] = 0;
					data[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp[0][1] = data[1][1];
			dp[1][1] = data[0][1];
			
			for(int i=2; i<= N; i++)
			{
				dp[0][i] = data[1][i] + max(dp[1][i-1], dp[1][i-2]);
				dp[1][i] = data[0][i] + max(dp[0][i-1], dp[0][i-2]);
			}
			
			if(dp[0][N] > dp[1][N]) bw.write(dp[0][N]+"\n");
			else bw.write(dp[1][N]+"\n");
		}
		bw.flush();
	}
	public static int max(int a, int b) { return a > b ? a : b; }
}
