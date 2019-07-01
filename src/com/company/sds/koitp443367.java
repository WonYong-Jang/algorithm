package com.company.sds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class koitp443367 {

	static int N, M;
	static char[] c1 = new char[1005];
	static char[] c2 = new char[1005];
	static int[][] dp = new int[1005][1005];
	static int[][] track = new int[1005][1005];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str1 = br.readLine();
		N = str1.length();
		String str2 = br.readLine();
		M = str2.length();
		
		for(int i=1; i<= N; i++)
		{
			c1[i] = str1.charAt(i-1);
		}
		for(int i=1; i<= M; i++)
		{
			c2[i] = str2.charAt(i-1);
		}
		
		for(int i=1; i<= N; i++)
		{
			for(int j=1; j<= M; j++)
			{
				if(c1[i] == c2[j]) {
					dp[i][j] = dp[i-1][j-1] + 1;
					track[i][j] = 5;
				}
				else {
					dp[i][j] = max(dp[i-1][j],dp[i][j-1]);
					if(dp[i][j] == dp[i-1][j]) {
						track[i][j] = 1;
					}
					else {
						track[i][j] = 2;
					}
				}
			}
		}
		solve(N, M, dp[N][M]);
		System.out.println();
	}
	public static void solve(int n, int m, int cnt)
	{
		if(cnt == 0) return;
		
		if(track[n][m] == 5) {
			solve(n-1,m-1,cnt-1);
			System.out.print(c1[n]);
		}
		else if(track[n][m] == 1) {
			solve(n-1,m,cnt);
		}
		else {
			solve(n,m-1,cnt);
		}
		
	}
	public static int max(int a, int b) { return a > b ? a : b; }
}
